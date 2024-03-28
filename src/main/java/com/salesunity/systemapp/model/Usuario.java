package com.salesunity.systemapp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id",nullable = false)
    private Long id;

    @Column(name = "usuario_name", nullable = false)
    private String name;

    @Column(name = "usuario_email", nullable = false)
    private String email;

    @Column(name = "usuario_senha", nullable = false)
    private String senha;
    @Column(name = "usuario_type", nullable = false)
    private boolean admin;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comprador", cascade = CascadeType.ALL)
    private List<Pedido> compras;
}
