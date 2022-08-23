package com.example.ApiTirage.service.impl;

import com.example.ApiTirage.model.Postulant;
import com.example.ApiTirage.repository.PostulantRepository;
import com.example.ApiTirage.service.PostulantService;
import org.springframework.stereotype.Service;

@Service
public class PostulantServiceImpl implements PostulantService {
    private PostulantRepository postulantRepository;

    @Override
    public Postulant savePostulant(Postulant postulant) {
        return null;
    }
}
