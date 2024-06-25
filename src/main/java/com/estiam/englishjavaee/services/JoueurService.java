package com.estiam.englishjavaee.services;

import com.estiam.englishjavaee.dao.JoueurDao;
import com.estiam.englishjavaee.pojos.Joueur;

import java.util.List;

public class JoueurService {
    private JoueurDao joueurDao = new JoueurDao();

    public void registerJoueur(Joueur joueur) {
        joueurDao.saveJoueur(joueur);
    }

    public Joueur login(String email, String motDePasse) {
        Joueur joueur = joueurDao.getJoueurByEmail(email);
        if (joueur != null && joueur.getMotDePasse().equals(motDePasse)) {
            return joueur;
        }
        return null;
    }

    public List<Joueur> getAllJoueurs() {
        return joueurDao.getAll();
    }
}
