package com.salesunity.systemapp.dto;


import com.salesunity.systemapp.model.Pedido;
import com.salesunity.systemapp.model.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class UsuarioDTO {

    private Long id;

    private String name;

    private String email;

    private String senha;

    private String role;

    private Long empresa_id;

    private List<Long> compras_id;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.role = usuario.getRole().getRole();
        this.empresa_id = usuario.getEmpresa().getId();
        if(usuario.getCompras() != null){
            this.compras_id = usuario.getCompras().stream().map(Pedido::getId).toList();
        }

    }
}
