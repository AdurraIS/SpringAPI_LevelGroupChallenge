package com.salesunity.systemapp.dto;

import com.salesunity.systemapp.model.Item;
import com.salesunity.systemapp.model.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PedidoDTO {

    private Long id;

    private Boolean concluido;

    private Long fornecedor;

    private Long comprador;

    private List<Long> items;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.fornecedor = pedido.getFornecedor().getId();
        this.comprador = pedido.getComprador().getId();
        if(pedido.getItems() != null){
            this.items = pedido.getItems().stream().map(Item::getId).toList();
        }
        this.concluido = pedido.getConcluido();
    }
}
