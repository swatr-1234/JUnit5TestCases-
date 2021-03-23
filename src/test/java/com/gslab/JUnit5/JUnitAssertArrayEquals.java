package com.gslab.JUnit5;

import com.gslab.JUnit5.bookservice.BookService;
import com.gslab.JUnit5.entity.Book;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAssertArrayEquals {

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
    @DisplayName("assertArrayEqualsWithNoMessage")
    public void assertArrayEqualsWithNoMessage() {

        String[] actualBookIds = bookService.getBookIdByPublisher( "tom" );
        Assertions.assertArrayEquals( new String[]{"1", "2"}, actualBookIds );

    }

    @Test
    @Order(2)
    @DisplayName("assertArrayEqualsWithMessage")
    public void assertArrayEqualsWithMessage() {

        String[] actualBookIds = bookService.getBookIdByPublisher( "tom" );
        Assertions.assertArrayEquals( new String[]{"2", "1"}, actualBookIds, "bookIds didn't matched" );
    }

    @Test
    @Order(3)
    @DisplayName("assertArrayEqualsWithSupplierMessage")
    public void assertArrayEqualsWithSupplierMessage() {

        String[] actualBookIds = bookService.getBookIdByPublisher( "tom" );
        Assertions.assertArrayEquals( new String[]{"2", "1"}, actualBookIds, () -> "bookIds didn't matched" );
    }
}
