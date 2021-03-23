package com.gslab.JUnit5;

import com.gslab.JUnit5.bookservice.BookService;
import com.gslab.JUnit5.entity.Book;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAssertIterableEquals {

    Book firstBook;
    Book secondBook;
    Book thirdBook;

    @Autowired
    BookService bookService;

    @BeforeEach
    public void setup( TestInfo testInfo ) {
        firstBook = new Book( "1", "JavaBrain", "tom" );
        secondBook = new Book( "2", "JavaBrain2.0", "tom" );
        thirdBook = new Book( "3", "JavaBrain3.0", "sammy" );
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        bookService.addBook( thirdBook );
        System.out.println( "Start..." + testInfo.getDisplayName() );
    }

    @AfterEach
    public void tearDown( TestInfo testInfo ) {
        System.out.println( "End..." + testInfo.getDisplayName() );
    }

    @Test
    @Order(1)
    @DisplayName("assertIterableEqualsWithNoMessage")
    public void assertIterableEqualsWithNoMessage() {

        List<String> actualBookTitles = bookService.getBookTitleByPublisher( "tom" );
        List<String> expectedBookTitles = new ArrayList<>();
        expectedBookTitles.add( "JavaBrain" );
        expectedBookTitles.add( "JavaBrain2.0" );
        Assertions.assertIterableEquals( expectedBookTitles, actualBookTitles );

    }

    @Test
    @Order(2)
    @DisplayName("assertIterableEqualsWithMessage")
    public void assertIterableEqualsWithMessage() {

        List<String> actualBookTitles = bookService.getBookTitleByPublisher( "tom" );
        List<String> expectedBookTitles = new ArrayList<>();
        expectedBookTitles.add( "JavaBrain" );
        expectedBookTitles.add( "JavaBrain2.0" );
        expectedBookTitles.add( "JavaBrain4.0" );
        Assertions.assertIterableEquals( expectedBookTitles, actualBookTitles, "bookTitles didn't matched" );
    }

    @Test
    @Order(3)
    @DisplayName("assertIterableEqualsWithSupplierMessage")
    public void assertIterableEqualsWithSupplierMessage() {
        List<String> actualBookTitles = bookService.getBookTitleByPublisher( "tom" );
        List<String> expectedBookTitles = new ArrayList<>();
        expectedBookTitles.add( "JavaBrain2.0" );
        expectedBookTitles.add( "JavaBrain" );
        Assertions.assertIterableEquals( expectedBookTitles, actualBookTitles, () -> "bookTitles didn't matched" );
    }
}

