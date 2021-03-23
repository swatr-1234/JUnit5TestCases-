package com.gslab.JUnit5;

import com.gslab.JUnit5.bookservice.BookService;
import com.gslab.JUnit5.entity.Book;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnit5AssertNull {
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
    @DisplayName( "assertNullWithNoMessage" )
    public void assertNullWithNoMessage(){
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        Book actualBook= bookService.getBookById( "15" );
        Assertions.assertNull(actualBook );

    }
    @Test
    @Order( 2 )
    @DisplayName( "assertNullWithMessage" )
    public void assertNullWithMessage(){
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        Book actualBook= bookService.getBookById( "15" );
        Assertions.assertNull(actualBook ,"Book is not present");

    }

    @Test
    @Order( 3 )
    @DisplayName( "assertNullWithSupplierMessage" )
    public void assertNullWithSupplierMessage(){
        bookService.addBook( firstBook );
        bookService.addBook( secondBook );
        Book actualBook= bookService.getBookById( "1" );
        Assertions.assertNull(actualBook ,()->"Book is present");

    }


}
