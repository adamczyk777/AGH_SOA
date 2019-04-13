package com.jadamczyk.books;

import com.jadamczyk.books.Entities.Book;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("CreateUpdateBookManager")
@ApplicationScoped
public class CreateUpdateBookManager {
    private String name;
    private String surname;
    private String title;
    private Double price;
    private Integer year;
    private String isbn;
    private Book bookToUpdate = null;
    private BookDAO dao = new BookDAO();

    public String populateBookData(Book book) {
        this.bookToUpdate = book;

        this.name = this.bookToUpdate.getName();
        this.surname= this.bookToUpdate.getSurname();
        this.title = this.bookToUpdate.getTitle();
        this.price= this.bookToUpdate.getPrice();
        this.year = this.bookToUpdate.getPublishYear();
        this.isbn = this.bookToUpdate.getIsbn();

        return "newBook/newBook.xhtml";
    }

    public Book getBookToUpdate() {
        return bookToUpdate;
    }

    public void setBookToUpdate(Book bookToUpdate) {
        this.bookToUpdate = bookToUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void saveBook() {
        Book newBook = new Book();
        newBook.setIsbn(this.isbn);
        newBook.setName(this.name);
        newBook.setSurname(this.surname);
        newBook.setPrice(this.price);
        newBook.setPublishYear(this.year);
        newBook.setTitle(this.title);
        this.dao.insertBook(newBook);
    }

    public void updateBook() {
        this.dao.updateBook(this.bookToUpdate);
    }

    public String submit() {
        if (this.bookToUpdate != null) {
            this.updateBook();

        } else {
            this.saveBook();
        }
        this.bookToUpdate = null;
        this.clearFields();
        return "../index.xhtml";
    }

    private void clearFields() {
        this.name = null;
        this.surname= null;
        this.title = null;
        this.price= null;
        this.year = null;
        this.isbn = null;
    }
}
