package com.gslab.JUnit5;

import com.gslab.JUnit5.bookservice.BookService;
import com.gslab.JUnit5.entity.Book;
import com.gslab.JUnit5.execution.BookNotFoundException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAssertThrows {

    Book firstBook;
    Book secondBook;

    @Autowired
    BookService bookService;

    @BeforeEach
    public void setup(TestInfo testInfo ) {
        firstBook= new Book( "1","JavaBrain","tom" );
        secondBook= new Book( "2","JavaBrain2.0","tom" );
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        System.out.println("Start..." + testInfo.getDisplayName());
    }
    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("End..." + testInfo.getDisplayName());
    }

    @Test
    @Order( 1 )
    @DisplayName( "assertThrowsWithNoMessage" )
    public void assertThrowsWithNoMessage(){
        Assertions.assertThrows( BookNotFoundException.class,()-> bookService.getBookByTitle( "JavaBrain4.0" ));
    }

    @Test
    @Order( 2 )
    @DisplayName( "assertThrowsWithMessage" )
    public void assertThrowsWithMessage(){
        Assertions.assertThrows( NullPointerException.class,()-> bookService.getBookByTitle( "JavaBrain4.0" ),"Different exception thrown.");
    }

    @Test
    @Order( 3 )
    @DisplayName( "assertThrowsWithSupplierMessage" )
    public void assertThrowsWithSupplierMessage(){
        Assertions.assertThrows( NullPointerException.class,()-> bookService.getBookByTitle( "JavaBrain4.0" ),()->"Different exception thrown.");
    }

}
