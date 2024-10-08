package com.estiam.englishjavaee.dao;

import com.estiam.englishjavaee.pojos.Partie;
import com.estiam.englishjavaee.utilities.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PartieDao {
    public void savePartie(Partie partie) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(partie);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Other CRUD Methods
}
