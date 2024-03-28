package com.salesunity.systemapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double price;
    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "Id")
    private Categoria category;
    @OneToOne
    @JoinColumn(name = "productType_id", referencedColumnName = "Id")
    private TipoProduto productType;

}
