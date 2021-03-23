package com.gslab.JUnit5;

import com.gslab.JUnit5.bookservice.BookService;
import com.gslab.JUnit5.entity.Book;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JUnit5AssertTrueTests {

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
    @DisplayName( "assertTrueWithNoMessage" )
    public void assertTrueWithNoMessage(){
        List<Book> listOfBook= bookService.books();
        Assertions.assertTrue(listOfBook.isEmpty());

    }
    @Test
    @Order( 2 )
    @DisplayName( "assertTrueWithCustomizeMessage" )
    public void assertTrueWithCustomizeMessage(){
        List<Book> listOfBook= bookService.books();
        listOfBook.add( book );
        Assertions.assertTrue( listOfBook.isEmpty(),"List of book is not empty" );
    }
    @Test
    @Order( 3 )
    @DisplayName( "assertTrueWithMessageSupplier" )
    public void assertTrueWithMessageSupplier(){
        List<Book> listOfBook= bookService.books();
        listOfBook.add( book );
        Assertions.assertTrue(listOfBook.isEmpty(),()->"List of book is not empty");

    }

    @Test
    @Order( 4 )
    @DisplayName( "assertTrueWithBooleanSupplierAndNoMessage" )
    public void assertTrueWithBooleanSupplierAndNoMessage(){
        List<Book> listOfBook= bookService.books();
        listOfBook.add( book );
        Assertions.assertTrue(()->listOfBook.isEmpty());

    }

    @Test
    @Order( 5 )
    @DisplayName( "assertTrueWithBooleanSupplierAndMessage" )
    public void assertTrueWithBooleanSupplierAndMessage(){
        List<Book> listOfBook= bookService.books();
        listOfBook.add( book );
        Assertions.assertTrue(()->listOfBook.isEmpty(),"List of book is not empty");

    }
    @Test
    @Order( 6 )
    @DisplayName( "assertTrueWithBooleanSupplierAndMessageSupplier" )
    public void assertTrueWithBooleanSupplierAndMessageSupplier(){
        List<Book> listOfBook= bookService.books();
        listOfBook.add( book );
        Assertions.assertTrue(()->listOfBook.isEmpty(),()->"List of book is not empty");

    }

}
