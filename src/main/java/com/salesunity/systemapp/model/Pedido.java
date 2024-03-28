package com.salesunity.systemapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id",nullable = false)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor_empresa_id",referencedColumnName = "empresa_id")
    private Empresa fornecedor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comprador_usuario_id",referencedColumnName = "usuario_id")
    private Usuario comprador;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Item> items;

}
