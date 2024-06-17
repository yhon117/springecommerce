package com.yhon.ecommerce.controller;

import com.yhon.ecommerce.entitys.DetalleOrden;
import com.yhon.ecommerce.entitys.Orden;
import com.yhon.ecommerce.entitys.Producto;
import com.yhon.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductoService productoService;

    List<DetalleOrden> listaOrden= new ArrayList<>();
    Orden orden = new Orden();

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
    public String carrito(@RequestParam Integer id, @RequestParam Integer cantidad){
        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = new Producto();
        double sumaTotal=0;
        Optional<Producto> optionalProducto= productoService.get(id);
        System.out.println("producto alladido: "+optionalProducto);
        System.out.println("cantidad: "+cantidad);
        return "usuario/carrito";
    }
}
