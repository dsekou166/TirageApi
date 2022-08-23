package com.example.ApiTirage.service.impl;

import com.example.ApiTirage.model.Postulant_S;
import com.example.ApiTirage.repository.PostulantTrieRepository;
import com.example.ApiTirage.service.PostulantTrieService;
import org.springframework.stereotype.Service;

@Service
public class PostulantTrieServiceImpl implements PostulantTrieService {
    private PostulantTrieRepository postulantTrieRepository;

    @Override
    public Postulant_S savePostulantTrie(Postulant_S postulantTrie) {
        return null;
    }
}
