package com.jadamczyk.books;

import com.jadamczyk.books.Entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.LinkedList;
import java.util.List;

public class BookDAO {

    private EntityManager entityManager;

    public BookDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminPersistenceUnit");
        this.entityManager = factory.createEntityManager();
    }



    public List<Book> findAll() {
        try {
            Query q = entityManager.createQuery("FROM Book");
            List<Book> result = q.getResultList();
            return result;
        } catch (Exception e) {
            System.err.println("Blad przy pobueraniu rekord—w: " + e);
            return new LinkedList<>();
        }
    }

    public Book findById(Integer id) {
        try {
            return this.entityManager.find(Book.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean insertBook(Book book) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(book);
            this.entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean deleteBook(Book book) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(book);
            this.entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean updateBook(Book book) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(book);
            this.entityManager.getTransaction().commit();

            return true;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return false;
        }
    }
}
