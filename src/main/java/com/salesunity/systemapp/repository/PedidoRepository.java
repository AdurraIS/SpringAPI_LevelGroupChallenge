package com.salesunity.systemapp.repository;

import com.salesunity.systemapp.model.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Page<Pedido> findByCompradorId(Pageable pageable, Long id);

}
