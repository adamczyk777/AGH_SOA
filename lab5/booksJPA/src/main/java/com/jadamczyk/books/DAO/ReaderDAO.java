package com.jadamczyk.books.DAO;

import com.jadamczyk.books.Entities.Author;
import com.jadamczyk.books.Entities.Reader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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

        } catch (Exception e) {

        }
    }

    @Override
    public Reader findById(Integer id) {
        try {

        } catch (Exception e) {

        }
    }

    @Override
    public Reader insert(Reader entity) {
        try {

        } catch (Exception e) {

        }
    }

    @Override
    public Reader delete(Reader entity) {
        try {

        } catch (Exception e) {

        }
    }

    @Override
    public Reader update(Reader entity) {
        try {

        } catch (Exception e) {

        }
    }
}

}
