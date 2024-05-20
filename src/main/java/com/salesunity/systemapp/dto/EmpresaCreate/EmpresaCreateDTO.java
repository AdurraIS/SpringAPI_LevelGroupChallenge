package com.salesunity.systemapp.dto.EmpresaCreate;

import com.salesunity.systemapp.dto.Usuario.UsuarioRequestDTO;
import com.salesunity.systemapp.model.Empresa;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class EmpresaCreateDTO {
    private Long id;

    private String name;

    private String cnpj;

    private int type;

    private String email;

    private List<UsuarioRequestDTO> usuarios;



    public EmpresaCreateDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.name = empresa.getName();
        this.cnpj = empresa.getCnpj();
        this.type = empresa.getType();
        this.email = empresa.getEmail();
        this.usuarios = empresa.getUsuarios().stream().map(UsuarioRequestDTO::new).toList();
    }
}
