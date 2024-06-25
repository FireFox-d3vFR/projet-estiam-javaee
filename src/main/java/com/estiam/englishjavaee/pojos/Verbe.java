package com.estiam.englishjavaee.pojos;

import jakarta.persistence.*;

@Entity
public class Verbe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String baseVerbale;
    private String preterit;
    private String participePasse;
    private String traduction;

    // Constructeurs

    public Verbe() {
    }

    public Verbe(String baseVerbale) {
        this.baseVerbale = baseVerbale;
    }

    public Verbe(String baseVerbale, String preterit, String participePasse) {
        this.baseVerbale = baseVerbale;
        this.preterit = preterit;
        this.participePasse = participePasse;
    }

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBaseVerbale() {
        return baseVerbale;
    }

    public void setBaseVerbale(String baseVerbale) {
        this.baseVerbale = baseVerbale;
    }

    public String getPreterit() {
        return preterit;
    }

    public void setPreterit(String preterit) {
        this.preterit = preterit;
    }

    public String getParticipePasse() {
        return participePasse;
    }

    public void setParticipePasse(String participePasse) {
        this.participePasse = participePasse;
    }

    public String getTraduction() {
        return traduction;
    }

    public void setTraduction(String traduction) {
        this.traduction = traduction;
    }
}
