package com.jadamczyk.books.JSON;

import com.jadamczyk.books.Entities.Author;

public class PlainBook {
    private Integer id;
    private Integer authorId;
    private String title;

    public Integer getId() {
        return id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }
}
