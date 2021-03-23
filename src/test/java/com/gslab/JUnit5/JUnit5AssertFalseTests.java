package com.gslab.JUnit5;

import com.gslab.JUnit5.bookservice.BookService;
import com.gslab.JUnit5.entity.Book;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnit5AssertFalseTests {

    Book book;

    @Autowired
    BookService bookService;

    @BeforeEach
    public void setup(TestInfo testInfo ) {
        book= new Book( "1","JavaBrain","tom" );
        System.out.println("Start..." + testInfo.getDisplayName());
    }
    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("End..." + testInfo.getDisplayName());
    }

    @Test
    @Order( 1 )
    @DisplayName( "assertFalseWithNoMessage" )
    public void assertFalseWithNoMessage(){
        List<Book> listOfBook= bookService.books();
        Assertions.assertFalse(listOfBook.isEmpty());

    }
    @Test
    @Order( 2 )
    @DisplayName( "assertFalseWithCustomizeMessage" )
    public void assertFalseWithCustomizeMessage(){
        List<Book> listOfBook= bookService.books();
        listOfBook.add( book );
        Assertions.assertFalse( listOfBook.isEmpty(),"List of book is empty" );
    }
    @Test
    @Order( 3 )
    @DisplayName( "assertFalseWithMessageSupplier" )
    public void assertFalseWithMessageSupplier(){
        List<Book> listOfBook= bookService.books();
        listOfBook.add( book );
        Assertions.assertFalse(listOfBook.isEmpty(),()->"List of book is empty");

    }

    @Test
    @Order( 4 )
    @DisplayName( "assertFalseWithBooleanSupplierAndNoMessage" )
    public void assertFalseWithBooleanSupplierAndNoMessage(){
        List<Book> listOfBook= bookService.books();
        listOfBook.add( book );
        Assertions.assertFalse(()->listOfBook.isEmpty());

    }

    @Test
    @Order( 5 )
    @DisplayName( "assertFalseWithBooleanSupplierAndMessage" )
    public void assertFalseWithBooleanSupplierAndMessage(){
        List<Book> listOfBook= bookService.books();
        listOfBook.add( book );
        Assertions.assertFalse(()->listOfBook.isEmpty(),"List of book is empty");

    }
    @Test
    @Order( 6 )
    @DisplayName( "assertFalseWithBooleanSupplierAndMessageSupplier" )
    public void assertFalseWithBooleanSupplierAndMessageSupplier(){
        List<Book> listOfBook= bookService.books();
        listOfBook.add( book );
        Assertions.assertFalse(()->listOfBook.isEmpty(),()->"List of book is empty");

    }

}

