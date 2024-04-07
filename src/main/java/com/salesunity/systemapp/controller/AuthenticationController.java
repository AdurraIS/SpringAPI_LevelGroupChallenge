package com.salesunity.systemapp.controller;

import com.salesunity.systemapp.dto.AuthenticationDTO;
import com.salesunity.systemapp.dto.LoginResponseDTO;
import com.salesunity.systemapp.dto.RegisterDTO;
import com.salesunity.systemapp.infra.security.TokenService;
import com.salesunity.systemapp.model.Usuario;
import com.salesunity.systemapp.model.roles.UsuarioRoles;
import com.salesunity.systemapp.repository.EmpresaRepository;
import com.salesunity.systemapp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;
    private final TokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, UsuarioRepository usuarioRepository, EmpresaRepository empresaRepository, TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.empresaRepository = empresaRepository;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Validated AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.getEmail(), data.getSenha());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterDTO registerDTO){
        if(this.usuarioRepository.findByEmail(registerDTO.getEmail()) != null){
            return ResponseEntity.badRequest().build();
        }
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.getSenha());
        Usuario usuario = new Usuario();
        usuario.setName(registerDTO.getName());
        usuario.setEmail(registerDTO.getEmail());
        usuario.setRole(UsuarioRoles.valueOf(registerDTO.getRole()));
        usuario.setSenha(encryptedPassword);
        usuario.setEmpresa(empresaRepository.findById(registerDTO.getEmpresa_id()).orElseThrow());
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }

}
