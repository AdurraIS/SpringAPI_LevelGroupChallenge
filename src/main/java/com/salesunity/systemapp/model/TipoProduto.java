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
public class TipoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_produto_id",nullable = false)
    private Long id;

    @Column(name = "tipo_produto_name",nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productType", cascade = CascadeType.ALL)
    private List<Produto> protudos;
}
