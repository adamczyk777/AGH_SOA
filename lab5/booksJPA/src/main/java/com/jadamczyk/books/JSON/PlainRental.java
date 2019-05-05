package com.jadamczyk.books.JSON;

import com.jadamczyk.books.Entities.Book;
import com.jadamczyk.books.Entities.Reader;

import java.util.Date;

public class PlainRental {
    private Integer id;
    private Integer readerId;
    private Integer bookId;
    private Date rentDate;
    private Date returnDate;

    public Integer getId() {
        return id;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Date getRentDate() {
        return rentDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }
}
