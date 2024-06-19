package com.yhon.ecommerce.service;

import com.sun.source.tree.OpensTree;
import com.yhon.ecommerce.entitys.Usuario;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> findById(Integer id);

}
