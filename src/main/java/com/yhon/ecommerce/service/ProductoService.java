package com.yhon.ecommerce.service;

import com.yhon.ecommerce.entitys.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Producto save(Producto producto);
    Optional<Producto> get(Integer id);
    void update(Producto producto);
    void delete(Integer id);
    List<Producto> finadAll();
}
