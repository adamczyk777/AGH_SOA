package com.jadamczyk.books.DAO;

import com.jadamczyk.books.Entities.Reader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ReaderDAO implements DAO<Reader> {
    private EntityManager entityManager;

    public ReaderDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminPersistenceUnit");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public List<Reader> findAll() {
        try {
            Query q = entityManager.createQuery("SELECT r FROM Reader r LEFT JOIN FETCH r.rentals");
            List<Reader> result = q.getResultList();
            return result;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

//    public List<Reader> findWithOrders(ReadersQuantity quantity) {
//        try {
//
//        } catch (Exception e) {
//
//        }
//    }

    @Override
    public Reader findById(Integer id) {
        try {
            return this.entityManager.find(Reader.class, id);
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Reader insert(Reader entity) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(entity);
            this.entityManager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Reader delete(Reader entity) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(entity);
            this.entityManager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Reader update(Reader entity) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(entity);
            this.entityManager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }
}

