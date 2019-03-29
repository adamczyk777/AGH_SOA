package com.jadamczyk.books;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("BookManager")
@ApplicationScoped
public class BookManager {
    private BookList bookList = new BookList();

    public BookList getBookList() {
        return bookList;
    }


}
