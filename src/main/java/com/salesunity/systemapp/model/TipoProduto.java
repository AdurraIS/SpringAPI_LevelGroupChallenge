package com.salesunity.systemapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
