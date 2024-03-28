package com.salesunity.systemapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pedido_id",nullable = false)
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fornecedor_empresa_id",referencedColumnName = "empresa_id")
    private Empresa fornecedor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comprador_usuario_id",referencedColumnName = "usuario_id")
    private Usuario comprador;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Item> items;

}
