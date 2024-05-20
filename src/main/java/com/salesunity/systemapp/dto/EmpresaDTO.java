package com.salesunity.systemapp.dto;

import com.salesunity.systemapp.model.Empresa;


import lombok.Getter;
import lombok.NoArgsConstructor;


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
