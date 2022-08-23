package com.example.ApiTirage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "postulant_S")
public class Postulant_S {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    private String prenom;
    private String numero;
    private String email;

    @ManyToOne
    private Tirage tirage;
}
