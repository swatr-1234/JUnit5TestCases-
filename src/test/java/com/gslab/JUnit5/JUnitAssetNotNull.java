package com.gslab.JUnit5;

import com.gslab.JUnit5.bookservice.BookService;
import com.gslab.JUnit5.entity.Book;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAssetNotNull {
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
    @DisplayName( "assertNotNullWithNoMessage" )
    public void assertNotNullWithNoMessage(){
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        Book actualBook= bookService.getBookById( "15" );
        Assertions.assertNotNull(actualBook );

    }
    @Test
    @Order( 2 )
    @DisplayName( "assertNotNullWithMessage" )
    public void assertNotNullWithMessage(){
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        Book actualBook= bookService.getBookById( "15" );
        Assertions.assertNotNull(actualBook ,"Book is not present");

    }

    @Test
    @Order( 3 )
    @DisplayName( "assertNotNullWithSupplierMessage" )
    public void assertNotNullWithSupplierMessage(){
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        Book actualBook= bookService.getBookById( "1" );
        Assertions.assertNotNull(actualBook ,()->"Book is present");

    }


}
