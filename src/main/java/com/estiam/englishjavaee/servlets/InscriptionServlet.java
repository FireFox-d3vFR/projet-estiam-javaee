package com.estiam.englishjavaee.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "inscriptionServlet", urlPatterns = "/inscription")
public class InscriptionServlet  extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,
        ServletException {
            // Créér les services
            // CityService cityService = new CityService();
            // List<City> city = cityService.getCity();
            // request.setAttribute("city", city);

            // Charge la vue
            this.getServletContext().getRequestDispatcher("/WEB-INF/inscription.jsp").forward(request, response);
    }
}
