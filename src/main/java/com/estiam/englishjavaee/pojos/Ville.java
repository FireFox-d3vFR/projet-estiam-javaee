package com.estiam.englishjavaee.pojos;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codePostal;
    private String nom;

    @OneToMany(mappedBy = "ville")
    private List<Joueur> joueurs;


    // Getters and Setters

    public Long getId() {
        return null;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Joueur> getJoueurs() {
        return joueurs;
    }

    public void setJoueurs(List<Joueur> joueurs) {
        this.joueurs = joueurs;
    }
}
