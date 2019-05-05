package com.jadamczyk.books.JSON;

import com.jadamczyk.books.Entities.Author;

public class PlainBook {
    private Integer id;
    private Author author;
    private String title;

    public Integer getId() {
        return id;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}
