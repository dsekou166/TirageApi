package com.example.ApiTirage.service.impl;

import com.example.ApiTirage.model.Liste;
import com.example.ApiTirage.model.Postulant;
import com.example.ApiTirage.model.Postulant_S;
import com.example.ApiTirage.model.Tirage;
import com.example.ApiTirage.repository.ListeRepository;
import com.example.ApiTirage.repository.PostulantRepository;
import com.example.ApiTirage.repository.PostulantTrieRepository;
import com.example.ApiTirage.repository.TirageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class FileService {
    PostulantRepository postulantRepository;
    ListeRepository listeRepository;
    PostulantTrieRepository postulantTrieRepository;
    TirageRepository tirageRepository;

    public FileService(PostulantRepository postulantRepository, ListeRepository listeRepository, PostulantTrieRepository postulantTrieRepository, TirageRepository tirageRepository) {
        this.postulantRepository = postulantRepository;
        this.listeRepository = listeRepository;
        this.postulantTrieRepository = postulantTrieRepository;
        this.tirageRepository = tirageRepository;
    }

    String line = "";
    public List<Postulant_S> chargerFichier(MultipartFile file, int nb_postulant) {
        try {
            String filename = "C:\\api_data\\" + file.getOriginalFilename();
            file.transferTo(new File(filename));
            BufferedReader br = new BufferedReader(new FileReader(filename));

            String toDay = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            //Création de la liste
            Liste liste = new Liste();
            liste.setDate(toDay);
            liste.setLibelle("Liste du " + toDay);
            listeRepository.save(liste);
            //Fin de la création de la liste

            //Parcourir le fichier jusqu'à la derniere ligne
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");

                //Créer un postulant
                Postulant p = new Postulant();
                p.setNom(data[0]);
                p.setPrenom(data[1]);
                p.setNumero(data[2]);
                p.setEmail(data[3]);
                p.setListe(liste);

                postulantRepository.save(p);

                //Fin de la création d'un postulant
            }

            //Création d'un tirage
            Tirage tirage = new Tirage();
            tirage.setDate_tirage(toDay);
            tirage.setLibelle("Tirage du " + toDay);
            tirageRepository.save(tirage);
            //Fin de la création d'un tirage


            //Recuperer les postulants de la liste
            List<Postulant> postulantSet = postulantRepository.findByListeId(liste.getId());

            //Melange la liste pour un tirage aleatoire
            Collections.shuffle(postulantSet);
            List<Postulant_S> postulantTrieList = new ArrayList<Postulant_S>();
            for (int i = 1; i <= nb_postulant; i++) {
                Postulant po = postulantSet.get(i);
                Postulant_S postulantTrie = new Postulant_S();
                postulantTrie.setId(po.getId());
                postulantTrie.setNom(po.getNom());
                postulantTrie.setPrenom(po.getPrenom());
                postulantTrie.setNumero(po.getNumero());
                postulantTrie.setEmail(po.getEmail());
                postulantTrie.setTirage(tirage);

                postulantTrieList.add(postulantTrie);

                postulantTrieRepository.save(postulantTrie);
            }
            return postulantTrieList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
