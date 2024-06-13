package com.yhon.ecommerce.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private String folder="imagenes//";
    public String saveImagen(MultipartFile multipartFile) throws IOException {
        if(!multipartFile.isEmpty()){
            byte[] bytes=multipartFile.getBytes();
            Path path= Paths.get(folder+multipartFile.getOriginalFilename());
            Files.write(path,bytes);
            return multipartFile.getOriginalFilename();
        }

        return "default.jpg";
    }

    public void deleteImagen(String nombre){
        String ruta="imagenes//";
        File file=new File(ruta+nombre);
        file.delete();

    }
}
