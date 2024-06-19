package com.yhon.ecommerce.repository;

import com.yhon.ecommerce.entitys.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
