package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.EmpresaCreate.EmpresaCreateDTO;
import com.salesunity.systemapp.dto.EmpresaDTO;
import com.salesunity.systemapp.dto.ItemResponseDTO;
import com.salesunity.systemapp.dto.Usuario.UsuarioRequestDTO;
import com.salesunity.systemapp.exceptions.EmpresaCreationFailed;
import com.salesunity.systemapp.exceptions.EmpresaNotFound;
import com.salesunity.systemapp.exceptions.ItemNotFound;
import com.salesunity.systemapp.exceptions.UserNotFound;
import com.salesunity.systemapp.model.Empresa;
import com.salesunity.systemapp.model.Usuario;
import com.salesunity.systemapp.model.roles.UsuarioRoles;
import com.salesunity.systemapp.repository.EmpresaRepository;
import com.salesunity.systemapp.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public EmpresaService(EmpresaRepository empresaRepository,
                          UsuarioRepository usuarioRepository){
        this.empresaRepository = empresaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Page<EmpresaDTO> getAllPaginable(Pageable pageable){
        return empresaRepository.findAll(pageable).map(EmpresaDTO::new);
    }
    public EmpresaDTO findById(Long id){
        return new EmpresaDTO(empresaRepository.findById(id).orElseThrow(EmpresaNotFound::new));

    }
    @Transactional
    public EmpresaCreateDTO saveEmpresa(EmpresaCreateDTO empresaDTO){
        Empresa empresa = new Empresa();
        empresa = empresaRepository.save(dtoToObject(empresa,empresaDTO));
        // verifica se o Usuarios não está vazio
        if(empresaDTO.getUsuarios() != null){
            // loop pelos usuarios do DTO
            List<Usuario> users = new ArrayList<>();
            for (UsuarioRequestDTO usuario : empresaDTO.getUsuarios()) {
                // verifica se o ID do item existe
                    Usuario user = new Usuario();
                    String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getSenha());
                    usuario.setSenha(encryptedPassword);
                    usuario.setEmpresa_id(empresa.getId());
                    usuarioRepository.save(dtoUserToObject(user, usuario));
                    users.add(user);
            }
            empresa.setUsuarios(users);
        }
        return new EmpresaCreateDTO(empresa);
    }
    public void deleteEmpresa(Long id){
        this.findById(id);
        empresaRepository.deleteById(id);
    }
    @Transactional
    public void updateEmpresa(EmpresaDTO empresaDTO){
        Empresa empresa = empresaRepository.findById(empresaDTO.getId()).orElseThrow(EmpresaNotFound::new);
        empresaRepository.save(dtoToObject(empresa, empresaDTO));
    }
    public Empresa dtoToObject(Empresa empresa, EmpresaDTO empresaDTO){
        empresa.setId(empresaDTO.getId());
        empresa.setName(empresaDTO.getName());
        empresa.setCnpj(empresaDTO.getCnpj());
        empresa.setType(empresaDTO.getType());
        empresa.setEmail(empresaDTO.getEmail());
        return empresa;
    }
    public Empresa dtoToObject(Empresa empresa, EmpresaCreateDTO empresaDTO){
        empresa.setId(empresaDTO.getId());
        empresa.setName(empresaDTO.getName());
        empresa.setCnpj(empresaDTO.getCnpj());
        empresa.setType(empresaDTO.getType());
        empresa.setEmail(empresaDTO.getEmail());
        return empresa;
    }
    public Usuario dtoUserToObject(Usuario usuario, UsuarioRequestDTO usuarioRequestDTO){
        usuario.setId(usuarioRequestDTO.getId());
        usuario.setRole(UsuarioRoles.valueOf(usuarioRequestDTO.getRole()));
        usuario.setName(usuarioRequestDTO.getName());
        usuario.setSenha(usuarioRequestDTO.getSenha());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setEmpresa(empresaRepository.findById(usuarioRequestDTO.getEmpresa_id()).orElseThrow(EmpresaNotFound::new));
        return usuario;
    }
}
