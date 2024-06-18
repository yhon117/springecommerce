package com.yhon.ecommerce.controller;

import com.yhon.ecommerce.entitys.DetalleOrden;
import com.yhon.ecommerce.entitys.Orden;
import com.yhon.ecommerce.entitys.Producto;
import com.yhon.ecommerce.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
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
    public String carrito(@RequestParam Integer id, @RequestParam Integer cantidad,Model model){
        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = new Producto();
        double sumaTotal=0;
        Optional<Producto> optionalProducto= productoService.get(id);
        producto=optionalProducto.get();

        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(producto.getPrecio());
        detalleOrden.setNombre(producto.getNombre());
        detalleOrden.setTotal(producto.getPrecio()*cantidad);
        detalleOrden.setProducto(producto);

        listaOrden.add(detalleOrden);

        sumaTotal=listaOrden.stream().mapToDouble(dt-> dt.getTotal()).sum();
        orden.setTotal(sumaTotal);
        model.addAttribute("cart",listaOrden);
        model.addAttribute("orden",orden);

        return "usuario/carrito";
    }

    //quitar producto del carrito

    @GetMapping("delete/cart/{id}")
    public String eliminarProductoCarrito(@PathVariable Integer id, Model model){
        List<DetalleOrden> newOrden= new ArrayList<>();

        //se elimina el producto de la lista por el id
        for(DetalleOrden detalleOrden:listaOrden){
            if(detalleOrden.getProducto().getId()!=id){
                newOrden.add(detalleOrden);
            }
        }

        //se agrega la nueva lista
        listaOrden=newOrden;

        double sumaTotal=0;
        sumaTotal=listaOrden.stream().mapToDouble(dt-> dt.getTotal()).sum();
        orden.setTotal(sumaTotal);
        model.addAttribute("cart",listaOrden);
        model.addAttribute("orden",orden);


        return "usuario/carrito";
    }
}
