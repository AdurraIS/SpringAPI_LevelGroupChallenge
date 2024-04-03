package com.salesunity.systemapp.service;

import com.salesunity.systemapp.dto.EmpresaDTO;
import com.salesunity.systemapp.dto.UsuarioDTO;
import com.salesunity.systemapp.model.Empresa;
import com.salesunity.systemapp.model.Usuario;
import com.salesunity.systemapp.repository.EmpresaRepository;
import com.salesunity.systemapp.repository.PedidoRepository;
import com.salesunity.systemapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
    public UsuarioDTO findById(Long id){
        return new UsuarioDTO(usuarioRepository.findById(id).orElseThrow());

    }
    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO){
        return new UsuarioDTO(usuarioRepository.save(dtoToObject(usuarioDTO)));

    }
    public void deleteUsuario(Long id){
        this.findById(id);
        usuarioRepository.deleteById(id);
    }
    public void updateUsuario(UsuarioDTO newUsuarioDTO){
        findById(newUsuarioDTO.getId());
        usuarioRepository.save(dtoToObject(newUsuarioDTO));
    }
    public Usuario dtoToObject(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario();
        usuario.setId(usuarioDTO.getId());
        usuario.setAdmin(usuarioDTO.isAdmin());
        usuario.setName(usuarioDTO.getName());
        usuario.setSenha(usuarioDTO.getSenha());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setEmpresa(empresaRepository.findById(usuarioDTO.getEmpresa_id()).orElseThrow());
        usuario.setCompras(pedidoRepository.findAllById(usuarioDTO.getCompras_id()));

        return usuario;
    }

}
