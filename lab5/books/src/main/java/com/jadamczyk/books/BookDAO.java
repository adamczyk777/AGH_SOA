package com.jadamczyk.books;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class BookDAO {
    public List<Book> findAll() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookPersistenceUnit");
        EntityManager em = factory.createEntityManager();

        try {
            Query q = em.createQuery("FROM Book", Book.class);
            return (List<Book>) q.getResultList();
        } catch (Exception e) {
            System.err.println("Blad przy pobueraniu rekord—w: " + e);
            return new LinkedList<Book>();
        }
    }

    public boolean insertBook(Book book) {
        return false;
    }

    public boolean deleteBook(Book book) {
        return false;
    }
}
