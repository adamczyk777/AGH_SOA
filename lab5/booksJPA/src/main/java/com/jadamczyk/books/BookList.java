package com.jadamczyk.books;

import com.jadamczyk.books.DAO.BookDAO;
import com.jadamczyk.books.Entities.Book;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BookList implements Cloneable {
    private List<Book> books;
    private BookDAO dao;

    public BookList() {
        this.dao = new BookDAO();
        this.books = new LinkedList<>(dao.findAll());
    }

    public BookList(BookList old) {
        this.books = new LinkedList<>(old.books);
    }

    public BookList updateBooks() {
        this.books = this.dao.findAll();
        return this;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    protected BookList clone() {
        return new BookList(this);
    }

    public BookList filterByAuthorName(String authorName) {
        if (authorName != null && !authorName.equals("")) {
            BookList newObj = this.clone();
            newObj.books = newObj.books.stream().filter(el -> el.getAuthor().getName().equals(authorName)).collect(Collectors.toList());
            return newObj;
        } else {
            return this;
        }
    }

    public BookList filterByAuthorSurname(String authorSurname) {
        if (authorSurname != null && !authorSurname.equals("")) {
            BookList newObj = this.clone();
            newObj.books = newObj.books.stream().filter(el -> el.getAuthor().getSurname().equals(authorSurname)).collect(Collectors.toList());
            return newObj;
        } else {
            return this;
        }
    }

    public BookList filterByBottomPrice(Double priceFrom) {
        if (priceFrom != null) {
            BookList newObj = this.clone();
            newObj.books = newObj.books.stream().filter(el -> el.getPrice() >= priceFrom).collect(Collectors.toList());
            return newObj;
        } else {
            return this;
        }
    }

    public BookList filterByTopPrice(Double priceTo) {
        if (priceTo != null) {
            BookList newObj = this.clone();
            newObj.books = newObj.books.stream().filter(el -> el.getPrice() <= priceTo).collect(Collectors.toList());
            return newObj;
        } else {
            return this;
        }
    }

    public List<Book> toPlainList() {
        return books;
    }

    public boolean deleteBook(Book book) {
        this.books.remove(book);
        return dao.delete(book);
    }
}
