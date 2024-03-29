package com.salesunity.systemapp.dto;

import com.salesunity.systemapp.model.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;

    private String description;

    private Double price;

    private Long category_id;

    private Long productType_id;

    private Long empresa_id;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.description = produto.getDescription();
        this.price = produto.getPrice();
        this.category_id = produto.getCategory().getId();
        this.productType_id = produto.getProductType().getId();
        this.empresa_id = produto.getEmpresa().getId();
    }
}
