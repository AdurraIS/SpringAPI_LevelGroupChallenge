package com.salesunity.systemapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TipoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipo_produto_id",nullable = false)
    private Long id;

    @Column(name = "tipo_produto_name",nullable = false)
    private String name;
}
