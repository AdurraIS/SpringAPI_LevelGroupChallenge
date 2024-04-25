package com.salesunity.systemapp.dto;

import com.salesunity.systemapp.dto.Usuario.UsuarioRequestDTO;
import com.salesunity.systemapp.dto.Usuario.UsuarioResponseDTO;
import com.salesunity.systemapp.model.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PedidoDTO {

    private Long id;

    private Boolean concluido;

    private EmpresaDTO fornecedor;

    private UsuarioResponseDTO comprador;

    private List<ItemDTO> items;

    public PedidoDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.fornecedor = new EmpresaDTO(pedido.getFornecedor());
        this.comprador = new UsuarioResponseDTO(pedido.getComprador());
        if(pedido.getItems() != null){
            this.items = pedido.getItems().stream().map(ItemDTO::new).toList();
        }
        this.concluido = pedido.getConcluido();
    }
}
