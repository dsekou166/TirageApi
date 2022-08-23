package com.example.ApiTirage.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "postulant")
public class Postulant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String numero;
    private String email;

    @ManyToOne
    private Liste liste;

}
