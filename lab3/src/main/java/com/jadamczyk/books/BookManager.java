package com.jadamczyk.books;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.*;

@Named("BookManager")
@ApplicationScoped
public class BookManager {
    private String authorFilter = null;
    private Double priceFromFilter = null;
    private Double priceToFilter = null;
    private BookType selectedGenre = null;
    private BookList bookList = new BookList();
    private Map<Integer, Boolean> addedToCart = new HashMap<>();
    private final List<BookType> bookTypes = new ArrayList<>(Arrays.asList(BookType.values()));

    public Map<Integer, Boolean> getAddedToCart() {
        return addedToCart;
    }

    public BookManager() {
        this.bookList.toPlainList().forEach(el -> this.addedToCart.put(el.getId(), false));
    }

    public List<BookType> getBookTypes() {
        return bookTypes;
    }

    public List<Book> getBookList() {
        return bookList
                .filterByAuthor(authorFilter)
                .filterByGenre(selectedGenre)
                .filterByBottomPrice(priceFromFilter)
                .filterByTopPrice(priceToFilter)
                .toPlainList();
    }

    public String getAuthorFilter() {
        return authorFilter;
    }

    public void setAuthorFilter(String authorFilter) {
        this.authorFilter = authorFilter;
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

    public BookType getSelectedGenre() {
        return selectedGenre;
    }

    public void setSelectedGenre(BookType selectedGenre) {
        this.selectedGenre = selectedGenre;
    }
}
