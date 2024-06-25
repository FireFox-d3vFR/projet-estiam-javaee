package com.estiam.englishjavaee.dao;

import com.estiam.englishjavaee.utilities.HibernateUtil;
import org.hibernate.Session;

public class Dao {
    protected Session session;

    /**
     * Méthode permettant de créér une session Hibernate
     * @return Un objet Session
     */
    protected Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    /**
     * Méthode permettant de fermer une session Hibernate
     * @return void
     */
    protected void closeSession() {
        session.close();
    }
}
