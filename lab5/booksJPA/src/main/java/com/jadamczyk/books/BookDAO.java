package com.jadamczyk.books;

import org.hibernate.Session;

import javax.persistence.*;
import javax.transaction.Transaction;
import java.util.LinkedList;
import java.util.List;

public class BookDAO {
    private EntityManager em;

    public BookDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminPersistenceUnit");
        this.em = factory.createEntityManager();
    }

    public List<Book> findAll() {
        try {
            Query q = this.em.createQuery("FROM Book");
            List<Book> result = q.getResultList();
            return result;
        } catch (Exception e) {
            System.err.println("Blad przy pobueraniu rekord—w: " + e);
            return new LinkedList<>();
        }
    }

    public boolean insertBook(Book book) {
        try {
            EntityTransaction tr = this.em.getTransaction();

            tr.begin();
            em.persist(book);
            tr.commit();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean deleteBook(Book book) {
        try {
            EntityTransaction tr = this.em.getTransaction();

            tr.begin();
            em.remove(book);
            tr.commit();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
