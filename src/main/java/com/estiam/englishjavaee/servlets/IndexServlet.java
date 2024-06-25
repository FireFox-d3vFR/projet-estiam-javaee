package com.estiam.englishjavaee.servlets;

import com.estiam.englishjavaee.pojos.Joueur;
import com.estiam.englishjavaee.services.JoueurService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class IndexServlet extends HttpServlet {
    private JoueurService joueurService = new JoueurService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String motDePasse = req.getParameter("motDePasse");

        Joueur joueur = joueurService.login(email, motDePasse);
        if (joueur != null) {
            req.getSession().setAttribute("joueur", joueur);
            resp.sendRedirect("jeu");
        } else {
            req.setAttribute("errorMessage", "Email ou Mot de passe incorrect");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
