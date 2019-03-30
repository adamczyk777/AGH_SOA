package com.jadamczyk.books;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BookList implements Cloneable {
    public BookList() {
        this.books.add(new Book(1, "Book 1", "Author 1", BookType.BIOGRAPHY, 16.99, Currency.EUR, 100));
        this.books.add(new Book(2, "Book 2", "Author 1", BookType.COMEDY, 9.99, Currency.EUR, 100));
        this.books.add(new Book(3, "Book 3", "Author 1", BookType.COMIC, 2.99, Currency.EUR, 100));
        this.books.add(new Book(4, "Book 4", "Author 1", BookType.HISTORIC, 3.99, Currency.EUR, 100));
        this.books.add(new Book(5, "Book 5", "Author 2", BookType.COMIC, 41.99, Currency.EUR, 100));
        this.books.add(new Book(6, "Book 6", "Author 2", BookType.LITERATURE_OF_FACT, 12.99, Currency.EUR, 100));
        this.books.add(new Book(7, "Book 7", "Author 3", BookType.SATIRE, 9.99, Currency.EUR, 100));
        this.books.add(new Book(8, "Book 8", "Author 3", BookType.FANTASY, 2.99, Currency.EUR, 100));
        this.books.add(new Book(9, "Book 9", "Author 3", BookType.THRILLER, 11.99, Currency.EUR, 100));
        this.books.add(new Book(10, "Book 10", "Author 3", BookType.HISTORIC, 12.99, Currency.EUR, 100));
        this.books.add(new Book(11, "Book 11", "Author 4", BookType.BUSINESS, 12.99, Currency.EUR, 100));
        this.books.add(new Book(12, "Book 12", "Author 4", BookType.HORROR, 19.99, Currency.EUR, 100));
        this.books.add(new Book(13, "Book 13", "Author 4", BookType.HISTORIC, 29.99, Currency.EUR, 100));
        this.books.add(new Book(14, "Book 14", "Author 4", BookType.BIOGRAPHY, 39.99, Currency.EUR, 100));
    }

    public BookList(BookList old) {
        this.books = new LinkedList<>(old.books);
    }

    private List<Book> books = new LinkedList<>();

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    protected BookList clone() {
        return new BookList(this);
    }

    public BookList filterByAuthor(String author) {
        if (author != null && !author.equals("")) {
            BookList newObj = this.clone();
            newObj.books = newObj.books.stream().filter(el -> el.getAuthor().equals(author)).collect(Collectors.toList());
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

    public BookList filterByGenre(BookType genre) {
        if (genre != null && genre != BookType._NONE) {
            BookList newObj = this.clone();
            newObj.books = newObj.books.stream().filter(el -> el.getType() == genre).collect(Collectors.toList());
            return newObj;
        } else {
            return this;
        }
    }

    public List<Book> toPlainList() {
        return books;
    }
}
