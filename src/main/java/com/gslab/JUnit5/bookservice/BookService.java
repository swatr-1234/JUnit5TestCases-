package com.gslab.JUnit5.bookservice;

import com.gslab.JUnit5.entity.Book;
import com.gslab.JUnit5.execution.BookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    private List<Book> listOfBooks = new ArrayList<>();

    public void addBook( Book book ) {

        listOfBooks.add( book );

    }

    public List<Book> books() {

        return listOfBooks;
    }

    public Book getBookById( String bookId ) {
        for ( Book book : listOfBooks ) {
            if ( bookId.equals( book.getBookId() ) ) {
                System.out.println( book );
                return book;
            }
        }
        return null;

    }

    public String[] getBookIdByPublisher( String publisher ) {
        List<String> bookIds = new ArrayList<>();
        for ( Book book : listOfBooks ) {
            if ( publisher.equalsIgnoreCase( book.getPublisher() ) )
                bookIds.add( book.getBookId() );
        }
        return bookIds.toArray( new String[bookIds.size()] );
    }

    public List<String> getBookTitleByPublisher( String publisher ) {
        List<String> bookTitles = new ArrayList<>();
        for ( Book book : listOfBooks ) {
            if ( publisher.equalsIgnoreCase( book.getPublisher() ) )
                bookTitles.add( book.getTitleBook() );
        }
        return bookTitles;
    }

    public Book getBookByTitle( String title ) {
        for ( Book book : listOfBooks ) {
            if ( title.equalsIgnoreCase( book.getTitleBook() ) ) {
                return book;
            }
        }
        throw new BookNotFoundException( "Book not found in BookStore!" );
    }
}