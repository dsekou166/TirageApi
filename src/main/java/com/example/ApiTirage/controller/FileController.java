package com.example.ApiTirage.controller;

import com.example.ApiTirage.model.Postulant_S;
import com.example.ApiTirage.service.impl.FileService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/Api/Tirage")
public class FileController {
    private FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping()
    public List<Postulant_S> chargerFichier(@RequestParam ("file") MultipartFile file, @RequestParam("nb_postulant") int nb_postulant) throws IllegalStateException{
       return this.fileService.chargerFichier(file, nb_postulant);
    }
}
