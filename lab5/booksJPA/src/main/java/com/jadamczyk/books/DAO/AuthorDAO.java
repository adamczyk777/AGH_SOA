package com.jadamczyk.books.DAO;

import com.jadamczyk.books.Entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AuthorDAO implements DAO<Author> {
    private EntityManager entityManager;

    public AuthorDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminPersistenceUnit");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public List<Author> findAll() {
        try {
            Query q = entityManager.createQuery("SELECT a FROM Author a");
            List<Author> result = q.getResultList();
            return result;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Author findById(Integer id) {
        try {
            return this.entityManager.find(Author.class, id);
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Author insert(Author entity) {
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
    public Author delete(Author entity) {
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
    public Author update(Author entity) {
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
