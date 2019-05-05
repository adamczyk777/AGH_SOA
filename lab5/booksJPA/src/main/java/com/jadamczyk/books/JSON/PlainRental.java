package com.jadamczyk.books.JSON;

import com.jadamczyk.books.Entities.Book;
import com.jadamczyk.books.Entities.Reader;

import java.util.Date;

public class PlainRental {
    private Integer id;
    private Reader reader;
    private Book book;
    private Date rentDate;
    private Date returnDate;

    public Integer getId() {
        return id;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
