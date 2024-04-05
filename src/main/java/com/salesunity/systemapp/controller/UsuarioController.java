package com.salesunity.systemapp.controller;

import com.salesunity.systemapp.dto.UsuarioDTO;
import com.salesunity.systemapp.service.UsuarioService;
import com.salesunity.systemapp.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Page<UsuarioDTO>> getPaginableUsuarios(@RequestParam(name = "page", defaultValue = "0") int page,
                                                                 @RequestParam(name = "size", defaultValue = "10") int size){
        PageRequest pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(usuarioService.getAllPaginable(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }
    @GetMapping("/empresa/{id}")
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarioByEmpresa(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.getAllByEmpresa(id));
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody UsuarioDTO usuarioDTO){
        return ResponseEntity.ok(usuarioService.saveUsuario(usuarioDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.updateUsuario(usuarioDTO);
        return ResponseEntity.noContent().build();
    }

}
