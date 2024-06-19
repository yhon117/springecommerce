package com.yhon.ecommerce.service.impl;

import com.yhon.ecommerce.entitys.Usuario;
import com.yhon.ecommerce.repository.UsuarioRepository;
import com.yhon.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }
}
