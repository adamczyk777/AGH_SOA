package com.jadamczyk.books.DAO;

import java.util.List;

public interface DAO<T> {
    public List<T> findAll();
    public T findById(Integer id);
    public T insert(T entity);
    public T delete(T entity);
    public T update(T entity);
}
