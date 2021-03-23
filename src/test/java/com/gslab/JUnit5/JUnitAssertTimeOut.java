package com.gslab.JUnit5;

import com.gslab.JUnit5.bookservice.BookService;
import com.gslab.JUnit5.entity.Book;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAssertTimeOut {

    @Autowired
    BookService bookService;

    @BeforeEach
    public void setup( TestInfo testInfo ) {
        System.out.println( "Start..." + testInfo.getDisplayName() );
    }

    @AfterEach
    public void tearDown( TestInfo testInfo ) {
        System.out.println( "End..." + testInfo.getDisplayName() );
    }

    @Test
    @Order(1)
    @DisplayName("assertTimeoutWithNoMessage")
    public void assertTimeoutWithNoMessage() {

        for ( int i = 1; i <= 10000; i++ ) {
            bookService.addBook( new Book( String.valueOf( i ), "Head First Java", "samuel" ) );
        }
        List<String> actualTitles = new ArrayList<>();
        Assertions.assertTimeout( Duration.ofMillis( 1 ), () -> {
            actualTitles.addAll( bookService.getBookTitleByPublisher( "samuel" ) );
        } );
        Assertions.assertEquals( 10000, actualTitles.size() );
    }

    @Test
    @Order(2)
    @DisplayName("assertTimeoutWithMessage")
    public void assertTimeoutWithMessage() {


        for ( int i = 1; i <= 10000; i++ ) {
            bookService.addBook( new Book( String.valueOf( i ), "Head First Java", "samuel" ) );
        }
        List<String> actualTitles = new ArrayList<>();
        Assertions.assertTimeout( Duration.ofMillis( 1 ), () -> {
            actualTitles.addAll( bookService.getBookTitleByPublisher( "samuel" ) );
        }, "performance issue with getBookTitleByPublisher method" );
        Assertions.assertEquals( 10000, actualTitles.size() );
    }

    @Test
    @Order(3)
    @DisplayName("assertTimeoutWithSupplierMessage")
    public void assertTimeoutWithSupplierMessage() {


        for ( int i = 1; i <= 10000; i++ ) {
            bookService.addBook( new Book( String.valueOf( i ), "Head First Java", "samuel" ) );
        }
        List<String> actualTitles = new ArrayList<>();
        Assertions.assertTimeout( Duration.ofMillis( 1 ), () -> {
            actualTitles.addAll( bookService.getBookTitleByPublisher( "samuel" ) );
        }, () -> "performance issue with getBookTitleByPublisher method" );
        Assertions.assertEquals( 10000, actualTitles.size() );
    }

    @Test
    @Order(4)
    @DisplayName("assertTimeoutPreemptivelyWithNoMessage")
    public void assertTimeoutPreemptivelyWithNoMessage() {

        for ( int i = 1; i <= 10000; i++ ) {
            bookService.addBook( new Book( String.valueOf( i ), "Head First Java", "samuel" ) );
        }
        List<String> actualTitles = new ArrayList<>();
        Assertions.assertTimeoutPreemptively( Duration.ofMillis( 1 ), () -> {
            actualTitles.addAll( bookService.getBookTitleByPublisher( "samuel" ) );
        } );
        Assertions.assertEquals( 10000, actualTitles.size() );
    }

    @Test
    @Order(5)
    @DisplayName("assertTimeoutPreemptivelyWithMessage")
    public void assertTimeoutPreemptivelyWithMessage() {


        for ( int i = 1; i <= 10000; i++ ) {
            bookService.addBook( new Book( String.valueOf( i ), "Head First Java", "samuel" ) );
        }
        List<String> actualTitles = new ArrayList<>();
        Assertions.assertTimeoutPreemptively( Duration.ofMillis( 1 ), () -> {
            actualTitles.addAll( bookService.getBookTitleByPublisher( "samuel" ) );
        }, "performance issue with getBookTitleByPublisher method" );
        Assertions.assertEquals( 10000, actualTitles.size() );
    }

    @Test
    @Order(6)
    @DisplayName("assertTimeoutPreemptivelyWithSupplierMessage")
    public void assertTimeoutPreemptivelyWithSupplierMessage() {


        for ( int i = 1; i <= 10000; i++ ) {
            bookService.addBook( new Book( String.valueOf( i ), "Head First Java", "samuel" ) );
        }
        List<String> actualTitles = new ArrayList<>();
        Assertions.assertTimeoutPreemptively( Duration.ofMillis( 1 ), () -> {
            actualTitles.addAll( bookService.getBookTitleByPublisher( "samuel" ) );
        }, () -> "performance issue with getBookTitleByPublisher method" );
        Assertions.assertEquals( 10000, actualTitles.size() );
    }
}

