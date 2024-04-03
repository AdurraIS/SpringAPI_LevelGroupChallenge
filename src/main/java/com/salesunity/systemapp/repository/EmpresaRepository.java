package com.salesunity.systemapp.repository;

import com.salesunity.systemapp.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;


@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Page<Empresa> findAll(Pageable pageable);

}
