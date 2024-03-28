package com.salesunity.systemapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id",nullable = false)
    private Long id;

    @Column(name = "categoria_name",nullable = false)
    private String name;
}
