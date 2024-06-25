package com.estiam.englishjavaee.servlets;

import com.estiam.englishjavaee.pojos.Joueur;
import com.estiam.englishjavaee.pojos.Ville;
import com.estiam.englishjavaee.services.JoueurService;
import com.estiam.englishjavaee.services.VilleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class InscriptionServlet  extends HttpServlet {
    private JoueurService joueurService = new JoueurService();
    private VilleService villeService = new VilleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Ville> villes = villeService.getAllVilles();
        req.setAttribute("villes", villes);
        req.getRequestDispatcher("inscription.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String motDePasse = req.getParameter("motDePasse");
        Long villeId = Long.parseLong(req.getParameter("ville"));

        if (email == null || email.isEmpty() ||
            nom == null || nom.isEmpty() ||
            prenom == null || prenom.isEmpty() ||
            motDePasse == null || motDePasse.isEmpty()) {
            req.setAttribute("error", "Tout les champs sont obligatoires.");
            doGet(req, resp);
            return;
        }

        Ville ville = villeService.getAllVilles().stream().filter(v -> v.getId().equals(villeId)).findFirst().orElse(null);

        Joueur joueur = new Joueur();
        joueur.setEmail(email);
        joueur.setNom(nom);
        joueur.setPrenom(prenom);
        joueur.setMotDePasse(motDePasse);
        joueur.setVille(ville);

        joueurService.registerJoueur(joueur);
        resp.sendRedirect("index");
    }
}
