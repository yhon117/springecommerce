package com.yhon.ecommerce.service.impl;

import com.yhon.ecommerce.entitys.Producto;
import com.yhon.ecommerce.repository.ProductoRepository;
import com.yhon.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoImpl implements ProductoService {

    @Autowired
    private ProductoRepository repository;

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Optional<Producto> get(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void update(Producto producto) {

        repository.save(producto);
    }

    @Override
    public void delete(Integer id) {

        repository.deleteById(id);
    }

    @Override
    public List<Producto> finadAll() {
        return repository.findAll();
    }
}
