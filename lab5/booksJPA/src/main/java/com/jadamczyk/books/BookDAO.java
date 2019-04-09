package com.jadamczyk.books;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

public class BookDAO {
    public List<Book> findAll() {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminPersistenceUnit");
            EntityManager em = factory.createEntityManager();
            Query q = em.createQuery("FROM Book");
            List<Book> result = q.getResultList();
            em.close();
            return result;
        } catch (Exception e) {
            System.err.println("Blad przy pobueraniu rekord—w: " + e);
            return new LinkedList<>();
        }
    }

    public boolean insertBook(Book book) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminPersistenceUnit");
            EntityManager em = factory.createEntityManager();
            EntityTransaction tr = em.getTransaction();

            tr.begin();
            em.persist(book);
            tr.commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean deleteBook(Book book) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminPersistenceUnit");
            EntityManager em = factory.createEntityManager();
            EntityTransaction tr = em.getTransaction();

            tr.begin();
            em.remove(book);
            tr.commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean updateBook(Book book) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminPersistenceUnit");
            EntityManager em = factory.createEntityManager();
            EntityTransaction tr = em.getTransaction();

            tr.begin();
            tr.commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
