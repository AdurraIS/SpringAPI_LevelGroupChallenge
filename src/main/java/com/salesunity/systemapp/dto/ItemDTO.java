package com.salesunity.systemapp.dto;

import com.salesunity.systemapp.model.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemDTO {

    private Long id;

    private Long produto_id;

    private int quantidade;

    private Double valorTotal;

    private Long pedido_id;

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.produto_id = item.getProduto().getId();
        this.quantidade = item.getQuantidade();
        this.valorTotal = item.getValorTotal();
        this.pedido_id = item.getPedido().getId();
    }

}
