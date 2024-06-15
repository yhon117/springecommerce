package com.yhon.ecommerce.controller;

import com.yhon.ecommerce.entitys.Producto;
import com.yhon.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("")
    public String home(Model model){

        model.addAttribute("productos",productoService.finadAll());
        return "usuario/home";
    }

    @GetMapping("/productohome/{id}")
    public String productoHome(@PathVariable Integer id,Model model){

        System.out.println("id eviado como parametro: "+id);
        Producto producto = new Producto();
        Optional<Producto> productoOptional=productoService.get(id);
        producto=productoOptional.get();

        model.addAttribute("producto",producto);
        return "usuario/productohome";
    }

    @PostMapping("/cart")
    public String carrito(){
        return "usuario/carrito";
    }
}
