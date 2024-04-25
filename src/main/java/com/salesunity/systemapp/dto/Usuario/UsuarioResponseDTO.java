package com.salesunity.systemapp.dto.Usuario;


import com.salesunity.systemapp.model.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsuarioResponseDTO {

    private Long id;

    private String name;

    private String email;

    private String senha;

    private String role;

    private String nomeEmpresa;


    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.role = usuario.getRole().getRole();
        this.nomeEmpresa = usuario.getEmpresa().getName();
    }
}
