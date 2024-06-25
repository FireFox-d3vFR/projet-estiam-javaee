package com.estiam.englishjavaee.dao;

import com.estiam.englishjavaee.pojos.Member;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MemberDao extends Dao {
    /**
     * Méthode permettant de récupérer un membre suivant son id
     * @return un Member
     */
    public Member findById(Long id) {
        Member member = null;

        try {
            session = openSession();
            member = (Member) session.get(Member.class, id);
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }

        return member;
    }

    /**
     * Méthode permettant de récupérer un member suivant son email
     * @return Un member
     */
    public Member findByEmail(String email) {
        Member member = null;

        try {
            session = openSession();
            Query<Member> query = session.createQuery("select m from Member as m where email = :email", Member.class);
            query.setParameter("email", email);
            member = query.getSingleResultOrNull();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }

        return member;
    }

    /**
     * Méthode permettant de récupérer la liste des members
     * @return La liste des members
     */
    public List<Member> findAll() {
        List<Member> members = null;

        try {
            session = openSession();
            Query<Member> query = session.createQuery("select m from Member as m", Member.class);
            members = query.getResultList();
        } catch (Exception ex) {
            throw ex;
        } finally {
            closeSession();
        }

        return members;
    }

    /**
     * Méthode permettant de créer un member
     * @return Member créé avec le nouvel id
     */
    public Member create(Member member) {
        Transaction transaction = null;

        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.persist(member);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw ex;
        } finally {
            closeSession();
        }

        return member;
    }

    /**
     * Méthode permettant de mettre à jour un member
     * @return Member mis à jour
     */
    public Member update(Member member) {

        Transaction transaction = null;

        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.merge(member);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw ex;
        } finally {
            closeSession();
        }

        return member;
    }

    /**
     * Méthode permettant de supprimer un member
     * @return void
     */
    public void delete(Member member) {

        Transaction transaction = null;

        try {
            session = openSession();
            transaction = session.beginTransaction();
            session.remove(member);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw ex;
        } finally {
            closeSession();
        }
    }
}
