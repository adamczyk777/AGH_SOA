package com.jadamczyk.books;

public class Book {
    private String title;
    private String author;
    private BookType type;
    private double price;
    private Currency currency;
    private int pageCount;
    private int id;

    public Book(int id, String title, String author, BookType type, double price, Currency currency, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
        this.price = price;
        this.currency = currency;
        this.pageCount = pageCount;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public BookType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public int getPageCount() {
        return pageCount;
    }
}
