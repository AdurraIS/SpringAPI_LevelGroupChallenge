package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.EmpresaDTO;
import com.salesunity.systemapp.dto.UsuarioDTO;
import com.salesunity.systemapp.model.Empresa;
import com.salesunity.systemapp.model.Usuario;
import com.salesunity.systemapp.model.roles.UsuarioRoles;
import com.salesunity.systemapp.repository.EmpresaRepository;
import com.salesunity.systemapp.repository.PedidoRepository;
import com.salesunity.systemapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final EmpresaRepository empresaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public UsuarioService(EmpresaRepository empresaRepository, UsuarioRepository usuarioRepository, PedidoRepository pedidoRepository) {
        this.empresaRepository = empresaRepository;
        this.usuarioRepository = usuarioRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Page<UsuarioDTO> getAllPaginable(Pageable pageable){
        return usuarioRepository.findAll(pageable).map(UsuarioDTO::new);
    }
    public List<UsuarioDTO> getAllByEmpresa(Long id){
        return usuarioRepository.findByEmpresa(id).stream().map(UsuarioDTO::new).toList();
    }
    public UsuarioDTO findById(Long id){
        return new UsuarioDTO(usuarioRepository.findById(id).orElseThrow());

    }
    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        return new UsuarioDTO(usuarioRepository.save(dtoToObject(usuario,usuarioDTO)));

    }
    public void deleteUsuario(Long id){
        this.findById(id);
        usuarioRepository.deleteById(id);
    }
    public void updateUsuario(UsuarioDTO newUsuarioDTO){
        Usuario usuario = usuarioRepository.findById(newUsuarioDTO.getId()).orElseThrow();
        usuarioRepository.save(dtoToObject(usuario, newUsuarioDTO));
    }
    public Usuario dtoToObject(Usuario usuario,UsuarioDTO usuarioDTO){
        usuario.setId(usuarioDTO.getId());
        usuario.setRole(UsuarioRoles.valueOf(usuarioDTO.getRole()));
        usuario.setName(usuarioDTO.getName());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setEmpresa(empresaRepository.findById(usuarioDTO.getEmpresa_id()).orElseThrow());
        if(usuarioDTO.getCompras_id() != null){
            usuario.setCompras(pedidoRepository.findAllById(usuarioDTO.getCompras_id()));
        }
        return usuario;
    }

}
