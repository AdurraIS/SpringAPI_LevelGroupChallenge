package com.salesunity.systemapp.dto;

import com.salesunity.systemapp.model.Categoria;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CategoriaDTO {

    private Long id;
    private String name;

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.name = categoria.getName();
    }

}
