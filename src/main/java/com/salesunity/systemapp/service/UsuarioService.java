package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.Usuario.UsuarioRequestDTO;
import com.salesunity.systemapp.dto.Usuario.UsuarioResponseDTO;
import com.salesunity.systemapp.exceptions.EmpresaNotFound;
import com.salesunity.systemapp.exceptions.UserNotFound;
import com.salesunity.systemapp.model.Usuario;
import com.salesunity.systemapp.model.roles.UsuarioRoles;
import com.salesunity.systemapp.repository.EmpresaRepository;
import com.salesunity.systemapp.repository.PedidoRepository;
import com.salesunity.systemapp.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final EmpresaRepository empresaRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(EmpresaRepository empresaRepository, UsuarioRepository usuarioRepository) {
        this.empresaRepository = empresaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Page<UsuarioResponseDTO> getAllPaginable(Pageable pageable){
        return usuarioRepository.findAll(pageable).map(UsuarioResponseDTO::new);
    }
    public List<UsuarioResponseDTO> getAllByEmpresa(Long id){
        return usuarioRepository.findByEmpresa(id).stream().map(UsuarioResponseDTO::new).toList();
    }
    public UsuarioResponseDTO findById(Long id){
        return new UsuarioResponseDTO(usuarioRepository.findById(id).orElseThrow(UserNotFound::new));

    }
    @Transactional
    public UsuarioRequestDTO saveUsuario(UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = new Usuario();
        return new UsuarioRequestDTO(usuarioRepository.save(dtoToObject(usuario, usuarioRequestDTO)));

    }
    public void deleteUsuario(Long id){
        this.findById(id);
        usuarioRepository.deleteById(id);
    }
    @Transactional
    public void updateUsuario(UsuarioRequestDTO newUsuarioRequestDTO){
        Usuario usuario = usuarioRepository.findById(newUsuarioRequestDTO.getId()).orElseThrow(UserNotFound::new);
        usuarioRepository.save(dtoToObject(usuario, newUsuarioRequestDTO));
    }
    public Usuario dtoToObject(Usuario usuario, UsuarioRequestDTO usuarioRequestDTO){
        usuario.setId(usuarioRequestDTO.getId());
        usuario.setRole(UsuarioRoles.valueOf(usuarioRequestDTO.getRole()));
        usuario.setName(usuarioRequestDTO.getName());
        usuario.setSenha(usuarioRequestDTO.getSenha());
        usuario.setEmail(usuarioRequestDTO.getEmail());
        usuario.setEmpresa(empresaRepository.findById(usuarioRequestDTO.getEmpresa_id()).orElseThrow(EmpresaNotFound::new));
        return usuario;
    }

}
