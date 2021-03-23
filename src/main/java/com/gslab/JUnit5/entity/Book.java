package com.gslab.JUnit5.entity;

public class Book {
    private String bookId;
    private String titleBook;
    private String publisher;

    public Book( String bookId, String titleBook, String publisher ) {
        this.bookId = bookId;
        this.titleBook = titleBook;
        this.publisher = publisher;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId( String bookId ) {
        this.bookId = bookId;
    }

    public String getTitleBook() {
        return titleBook;
    }

    public void setTitleBook( String titleBook ) {
        this.titleBook = titleBook;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher( String publisher ) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", titleBook='" + titleBook + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}