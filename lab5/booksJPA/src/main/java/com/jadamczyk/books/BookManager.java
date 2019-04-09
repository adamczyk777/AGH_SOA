package com.jadamczyk.books;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.*;

@Named("BookManager")
@ApplicationScoped
public class BookManager {
    private String authorNameFilter = null;
    private String authorSurnameFilter = null;
    private Double priceFromFilter = null;
    private Double priceToFilter = null;
    private BookList bookList = new BookList();

    public List<Book> getBookList() {
        return bookList
                .filterByAuthorName(authorNameFilter)
                .filterByAuthorSurname(authorSurnameFilter)
                .filterByBottomPrice(priceFromFilter)
                .filterByTopPrice(priceToFilter)
                .toPlainList();
    }

    public String getAuthorNameFilter() {
        return authorNameFilter;
    }

    public void setAuthorNameFilter(String authorFilter) {
        this.authorNameFilter = authorFilter;
    }

    public String getAuthorSurnameFilter() {
        return authorSurnameFilter;
    }

    public void setAuthorSurnameFilter(String authorFilter) {
        this.authorSurnameFilter = authorFilter;
    }

    public Double getPriceFromFilter() {
        return priceFromFilter;
    }

    public void setPriceFromFilter(Double priceFromFilter) {
        this.priceFromFilter = priceFromFilter;
    }

    public Double getPriceToFilter() {
        return priceToFilter;
    }

    public void setPriceToFilter(Double priceToFilter) {
        this.priceToFilter = priceToFilter;
    }

    public boolean deleteBook(Book book) {
        return this.bookList.deleteBook(book);
    }
}
