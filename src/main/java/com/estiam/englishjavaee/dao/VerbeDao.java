package com.estiam.englishjavaee.dao;

import com.estiam.englishjavaee.pojos.Verbe;
import com.estiam.englishjavaee.utilities.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class VerbeDao {
    public List<Verbe> getAllVerbes() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Verbe", Verbe.class).list();
        }
    }

    public Verbe getVerbeById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Verbe.class, id);
        }
    }

    // Other CRUD Methods
}
