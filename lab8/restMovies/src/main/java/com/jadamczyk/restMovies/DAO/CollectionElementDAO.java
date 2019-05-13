package com.jadamczyk.restMovies.DAO;

import com.jadamczyk.restMovies.Entities.CollectionElement;
import com.jadamczyk.restMovies.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CollectionElementDAO {
    private EntityManager entityManager;

    public CollectionElementDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("MainPersistenceUnit");
        this.entityManager = factory.createEntityManager();
    }

    public List<CollectionElement> findAll(User user) {
        try {
            Query q = entityManager.createQuery("SELECT a FROM CollectionElement a WHERE a.user = user");
            List<CollectionElement> result = q.getResultList();
            return result;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }    }

    public CollectionElement findById(Integer id) {
        try {
            return this.entityManager.find(CollectionElement.class, id);
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    public CollectionElement insert(CollectionElement entity) {
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

    public CollectionElement delete(CollectionElement entity) {
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

    public CollectionElement update(CollectionElement entity) {
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
