package com.salesunity.systemapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class LoginResponseDTO {

    private String token;
    private String nomeUsuario;
    public LoginResponseDTO(String token, String nomeUsuario) {
        this.token = token;
        this.nomeUsuario = nomeUsuario;
    }
}
