package com.salesunity.systemapp.model;

import com.salesunity.systemapp.dto.EmpresaDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empresa_id")
    private Long id;

    @Column(name = "empresa_name", nullable = false)
    private String name;

    @Column(name = "empresa_cnpj", nullable = false)
    private String cnpj;

    @Column(name = "empresa_type", nullable = false)
    private int type;

    @Column(name = "empresa_email",nullable = false)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Usuario> usuarios;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Pedido> vendas;

}
