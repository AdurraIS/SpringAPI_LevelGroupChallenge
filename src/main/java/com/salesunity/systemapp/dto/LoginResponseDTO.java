package com.salesunity.systemapp.dto;

import com.salesunity.systemapp.model.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDTO {

    private String token;
    private String nomeUsuario;
    private Long id;
    public LoginResponseDTO(String token, Usuario usuario) {
        this.token = token;
        this.nomeUsuario = usuario.getName();
        this.id = usuario.getId();
    }
}
