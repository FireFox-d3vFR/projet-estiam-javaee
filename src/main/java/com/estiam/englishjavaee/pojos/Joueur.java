package com.estiam.englishjavaee.pojos;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String nom;
    private String prenom;
    private String motDePasse;

    @ManyToOne
    @JoinColumn(name = "ville_id")
    private Ville ville;

    @OneToMany(mappedBy = "joueur")
    private List<Partie> parties;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public List<Partie> getParties() {
        return parties;
    }

    public void setParties(List<Partie> parties) {
        this.parties = parties;
    }
}
