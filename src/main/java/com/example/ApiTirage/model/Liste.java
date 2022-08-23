package com.example.ApiTirage.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "liste")
public class Liste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String libelle;
    private String date;

    @OneToMany(mappedBy = "liste")
    private Set<Postulant> postulants = new HashSet<>();

}
