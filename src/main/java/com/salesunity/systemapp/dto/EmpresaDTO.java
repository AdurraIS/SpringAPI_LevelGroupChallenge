package com.salesunity.systemapp.dto;

import com.salesunity.systemapp.model.Empresa;
import com.salesunity.systemapp.model.Pedido;
import com.salesunity.systemapp.model.Produto;
import com.salesunity.systemapp.model.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class EmpresaDTO {

    private Long id;

    private String name;

    private String cnpj;

    private int type;

    private String email;


    public EmpresaDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.name = empresa.getName();
        this.cnpj = empresa.getCnpj();
        this.type = empresa.getType();
        this.email = empresa.getEmail();

    }
}
