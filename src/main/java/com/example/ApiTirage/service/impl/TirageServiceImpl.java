package com.example.ApiTirage.service.impl;

import com.example.ApiTirage.model.Tirage;
import com.example.ApiTirage.repository.TirageRepository;
import com.example.ApiTirage.service.TirageService;
import org.springframework.stereotype.Service;

@Service
public class TirageServiceImpl implements TirageService {

    private TirageRepository tirageRepository;

    @Override
    public Tirage saveTirage(Tirage tirage) {
        return null;
    }
}
