package com.jadamczyk.books.DAO;

import com.jadamczyk.books.Entities.Rental;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class RentalDAO implements DAO<Rental> {
    private EntityManager entityManager;

    public RentalDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminPersistenceUnit");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public List<Rental> findAll() {
        try {
            Query q = entityManager.createQuery("FROM Rental");
            List<Rental> result = q.getResultList();
            return result;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Rental findById(Integer id) {
        try {
            return this.entityManager.find(Rental.class, id);
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Rental insert(Rental entity) {
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
    public Rental delete(Rental entity) {
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
    public Rental update(Rental entity) {
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
