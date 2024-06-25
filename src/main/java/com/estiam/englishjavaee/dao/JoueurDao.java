package com.estiam.englishjavaee.dao;

import com.estiam.englishjavaee.pojos.Joueur;
import com.estiam.englishjavaee.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class JoueurDao {
    public void saveJoueur(Joueur joueur) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(joueur);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Joueur getJoueurByEmail(String email) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Joueur WHERE email = :email", Joueur.class)
                .setParameter("email", email)
                .uniqueResult();
        }
    }

    public List<Joueur> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Joueur").list();
        }
    }

    // Other CRUD methods
}
