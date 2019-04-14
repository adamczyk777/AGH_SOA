package com.jadamczyk.books.DAO;

import com.jadamczyk.books.Entities.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

        } catch (Exception e) {

        }
    }

    @Override
    public Author findById(Integer id) {
        try {

        } catch (Exception e) {

        }
    }

    @Override
    public Author insert(Author entity) {
        try {

        } catch (Exception e) {

        }
    }

    @Override
    public Author delete(Author entity) {
        try {

        } catch (Exception e) {

        }
    }

    @Override
    public Author update(Author entity) {
        try {

        } catch (Exception e) {

        }
    }
}
