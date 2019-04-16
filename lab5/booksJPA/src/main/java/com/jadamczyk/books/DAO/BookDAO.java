package com.jadamczyk.books.DAO;

import com.jadamczyk.books.Entities.Author;
import com.jadamczyk.books.Entities.Book;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class BookDAO implements DAO<Book> {
    private EntityManager entityManager;

    public BookDAO() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AdminPersistenceUnit");
        this.entityManager = factory.createEntityManager();
    }

    @Override
    public List<Book> findAll() {
        try {
            Query q = entityManager.createQuery("SELECT b FROM Book b");
            List<Book> result = q.getResultList();
            return result;
        } catch (Exception e) {
            System.err.println("Blad przy pobueraniu rekord—w: " + e);
            return new LinkedList<>();
        }
    }

    @Override
    public Book findById(Integer id) {
        try {
            return this.entityManager.find(Book.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Book> findByAuthor(Author author) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Book> query = cb.createQuery(Book.class);
            Root<Book> bookQuery = query.from(Book.class);
            TypedQuery<Book> tq = entityManager.createQuery(query.select(bookQuery).where(cb.equal(bookQuery.get("author"), author)));
            return tq.getResultList();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Book insert(Book book) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(book);
            this.entityManager.getTransaction().commit();
            return book;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Book delete(Book book) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(book);
            this.entityManager.getTransaction().commit();
            return book;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    public Book update(Book book) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(book);
            this.entityManager.getTransaction().commit();

            return book;
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            System.out.println(e.toString());
            return null;
        }
    }
}
