package com.salesunity.systemapp.dto;

import com.salesunity.systemapp.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemResponseDTO {

    private Long id;

    private String produto;

    private int quantidade;

    private Double valorTotal;


    public ItemResponseDTO(Item item) {
        this.id = item.getId();
        this.produto = item.getProduto().getProductType().getName();
        this.quantidade = item.getQuantidade();
        this.valorTotal = item.getValorTotal();
    }

}
