package com.jadamczyk.books;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class BookList {
    public BookList() {
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
        this.books.add(new Book("Book 1", "Author 1", BookType.BIOGRAPHY, 12.99, Currency.EUR, 100));
    }

    private List<Book> books = new LinkedList<>();

    private Optional<Double> bottomPriceFilter = Optional.empty();
    private Optional<Double> topPriceFilter = Optional.empty();
    private Optional<String> authorFilter = Optional.empty();
    private Optional<BookType> genreFilter = Optional.empty();

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setBottomPriceFilter(double bottomPriceFilter) {
        this.bottomPriceFilter = Optional.of(bottomPriceFilter);
    }

    public void setTopPriceFilter(double topPriceFilter) {
        this.topPriceFilter = Optional.of(topPriceFilter);
    }

    public void setAuthorFilter(String authorFilter) {
        this.authorFilter = Optional.of(authorFilter);
    }

    public void setGenreFilter(BookType genreFilter) {
        this.genreFilter = Optional.of(genreFilter);
    }
}
