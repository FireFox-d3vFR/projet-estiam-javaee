package com.estiam.englishjavaee.dao;

import com.estiam.englishjavaee.pojos.Ville;
import com.estiam.englishjavaee.utilities.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class VilleDao {
    public List<Ville> getAllVilles() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Ville", Ville.class).list();
        }
    }

    public Ville getVilleById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Ville.class, id);
        }
    }

    // Other CRUD Methods
}
