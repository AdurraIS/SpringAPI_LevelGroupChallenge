package com.salesunity.systemapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "produto_id",nullable = false)
    private Long id;

    @Column(name = "produto_description",nullable = false)
    private String description;

    @Column(name = "produto_price",nullable = false)
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_category_id", referencedColumnName = "categoria_id")
    private Categoria category;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_productType_id", referencedColumnName = "tipo_produto_id")
    private TipoProduto productType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Item> itens;
}
