package com.estiam.englishjavaee.pojos;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", length = 100)
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    private String ville;

    @ManyToOne
    private City city;

    // constructeur

    public Member() {
    }

    public Member(String nom, String prenom, String email, String motDePasse, String ville) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.ville = ville;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Member{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email ='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}
