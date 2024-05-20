package com.salesunity.systemapp.dto.Usuario;


import com.salesunity.systemapp.model.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UsuarioRequestDTO {

    private Long id;

    private String name;

    private String email;

    private String senha;

    private String role;

    private Long empresa_id;


    public UsuarioRequestDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.role = usuario.getRole().getRole();
        this.empresa_id = usuario.getEmpresa().getId();
    }
}
