package com.salesunity.systemapp.repository;

import com.salesunity.systemapp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT u FROM Usuario u WHERE u.empresa.id = :empresaId")
    List<Usuario> findByEmpresa(Long empresaId);
    @Query("SELECT u.name FROM Usuario u WHERE u.email = :email")
    String findNameByEmail(String email);
    UserDetails findByEmail(String email);
}
