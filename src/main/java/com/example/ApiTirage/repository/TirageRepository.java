package com.example.ApiTirage.repository;

import com.example.ApiTirage.model.Tirage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TirageRepository extends JpaRepository<Tirage, Long> {
}
