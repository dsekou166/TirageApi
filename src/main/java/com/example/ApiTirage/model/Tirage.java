package com.example.ApiTirage.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "tirage")
public class Tirage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    private String date_tirage;

    @OneToMany(mappedBy = "tirage")
    private Set<Postulant_S> postulantTries = new HashSet<>();
}
