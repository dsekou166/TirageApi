package com.example.ApiTirage.repository;

import com.example.ApiTirage.model.Postulant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostulantRepository extends JpaRepository<Postulant, Long> {

    public List<Postulant> findByListeId(Long liste_id);
}
