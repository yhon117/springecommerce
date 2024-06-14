package com.yhon.ecommerce.controller;

import com.yhon.ecommerce.entitys.Producto;
import com.yhon.ecommerce.entitys.Usuario;
import com.yhon.ecommerce.service.FileService;
import com.yhon.ecommerce.service.ProductoService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private FileService fileService;

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("productos",productoService.finadAll());
        return "productos/show";
    }
    @GetMapping("/create")
    public String create(){
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {

        Usuario usuario =new Usuario(1,"","","","","","","");
        producto.setUsuario(usuario);
        System.out.println("este es el producto: "+producto.toString());
        productoService.save(producto);
        //imagen

        if(producto.getId()==null){//validacion cuando se crea un producto
            String nombreImgen=fileService.saveImagen(file);
            producto.setImagen(nombreImgen);
        }else{
            if(file.isEmpty()){//se edita el producto pero no se cambia la imagen
                 Producto p = new Producto();
                 p=productoService.get(producto.getId()).get();
                 producto.setImagen(p.getImagen());
            }else{
                String nombreImgen=fileService.saveImagen(file);
                producto.setImagen(nombreImgen);
            }
        }
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id,Model model){
        Producto producto = new Producto();
        Optional<Producto> optionalProducto =productoService.get(id);
        producto=optionalProducto.get();
        System.out.println("este es el producto: "+producto);

        model.addAttribute("producto",producto);
        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto){
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        productoService.delete(id);
        return "redirect:/productos";
    }




}
