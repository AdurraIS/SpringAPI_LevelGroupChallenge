package com.salesunity.systemapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id",nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "fk_produto_id", referencedColumnName = "produto_id")
    private Produto produto;

    @Column(name = "item_quantidade",nullable = false)
    private int quantidade;

    @Column(name = "item_valor_total",nullable = false)
    private Double valorTotal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_pedido_id",referencedColumnName = "pedido_id")
    private Pedido pedido;

    /*Item DTO Constructor
        valorTotal = itemDTO.produto * itemDTO.quantidade;
     */
}
