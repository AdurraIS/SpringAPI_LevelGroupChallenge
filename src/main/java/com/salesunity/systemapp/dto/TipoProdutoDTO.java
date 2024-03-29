package com.salesunity.systemapp.dto;

import com.salesunity.systemapp.model.TipoProduto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TipoProdutoDTO {

    private Long id;
    private String name;

    public TipoProdutoDTO(TipoProduto tipoProduto) {
        this.id = tipoProduto.getId();
        this.name = tipoProduto.getName();
    }
}
