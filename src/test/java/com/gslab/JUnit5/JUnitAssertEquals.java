package com.gslab.JUnit5;

import com.gslab.JUnit5.bookservice.BookService;
import com.gslab.JUnit5.entity.Book;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAssertEquals {

    Book firstBook;
    Book secondBook;

    @Autowired
    BookService bookService;

    @BeforeEach
    public void setup( TestInfo testInfo ) {
        firstBook= new Book( "1","JavaBrain","tom" );
        secondBook= new Book( "2","JavaBrain2.0","tom" );
        System.out.println("Start..." + testInfo.getDisplayName());
    }
    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("End..." + testInfo.getDisplayName());
    }

    @Test
    @Order( 1 )
    @DisplayName( "assertEqualsWithNoMessage" )
    public void assertEqualsWithNoMessage(){
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        Book actualBook= bookService.getBookById( "1" );
        Assertions.assertEquals("1",actualBook.getBookId() );
        Assertions.assertEquals("JavaBrain",actualBook.getTitleBook() );
    }

    @Test
    @Order( 2 )
    @DisplayName( "assertEqualsWithMessage" )
    public void assertEqualsWithMessage(){
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        Book actualBook= bookService.getBookById( "1" );
        Assertions.assertEquals("1",actualBook.getBookId(),"Book id didn't matched" );
        Assertions.assertEquals("JavaBrain1.0",actualBook.getTitleBook() ,"Book title didn't matched");

    }

    @Test
    @Order( 3 )
    @DisplayName( "assertEqualsWithSupplierMessage" )
    public void assertEqualsWithSupplierMessage(){
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        Book actualBook= bookService.getBookById( "1" );
        Assertions.assertEquals("1",actualBook.getBookId(),()->"Book id didn't matched" );
        Assertions.assertEquals("JavaBrain1.0",actualBook.getTitleBook() ,()->"Book title didn't matched");

    }
}
