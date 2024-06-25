package com.estiam.englishjavaee.servlets;

import com.estiam.englishjavaee.pojos.Joueur;
import com.estiam.englishjavaee.pojos.Partie;
import com.estiam.englishjavaee.pojos.Verbe;
import com.estiam.englishjavaee.services.PartieService;
import com.estiam.englishjavaee.services.VerbeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class JeuServlet extends HttpServlet {
    private VerbeService verbeService = new VerbeService();
    private PartieService partieService = new PartieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Joueur joueur = (Joueur) req.getSession().getAttribute("joueur");
        if (joueur == null) {
            resp.sendRedirect("index");
            return;
        }

        List<Verbe> verbes = verbeService.getAllVerbes();

        if (verbes.isEmpty()) {
            req.setAttribute("error", "Aucun verbe disponible pour le jeu.");
            return;
        }

        Verbe verbe = verbes.get(new Random().nextInt(verbes.size()));

        req.setAttribute("verbe", verbe);
        req.getRequestDispatcher("jeu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Joueur joueur = (Joueur) session.getAttribute("joueur");

        if (joueur == null) {
            resp.sendRedirect("index");
            return;
        }

        String baseVerbale = req.getParameter("baseVerbale");
        String preterit = req.getParameter("preterit");
        String participePasse = req.getParameter("participePasse");

        List<Verbe> verbes = verbeService.getAllVerbes();
        Verbe verbe = verbes.stream().filter(v -> v.getBaseVerbale().equals(baseVerbale)).findFirst().orElse(null);

        if (verbe != null && verbe.getPreterit().equals(preterit) && verbe.getParticipePasse().equals(participePasse)) {
            Partie partie = new Partie();
            partie.setJoueur(joueur);
            partie.setScore(1); // Increment score logic can be added
            partieService.createPartie(partie);
            req.getRequestDispatcher("jeu.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("fin");
        }
    }
}
