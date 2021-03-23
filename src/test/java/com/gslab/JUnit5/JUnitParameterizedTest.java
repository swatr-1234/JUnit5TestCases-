package com.gslab.JUnit5;

import com.gslab.JUnit5.execution.StringHelper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitParameterizedTest {
    StringHelper s;

    @BeforeEach
    public void setup( TestInfo testInfo ) {
        s = new StringHelper();
        System.out.println( "Start..." + testInfo.getDisplayName() );
    }

    @AfterEach
    public void tearDown( TestInfo testInfo ) {
        System.out.println( "End..." + testInfo.getDisplayName() );
    }

    @ParameterizedTest(name = "testEvenValues")
    @ValueSource(ints = {2, 4, 6, 8, 10})
    @Order(1)
    public void testEvenValues( int number ) {
        Calculator c = new Calculator();
        Assertions.assertTrue( () -> c.isEvenNumber( number ), () -> "Number is not even." );

    }

    @ParameterizedTest( name="testReverseDemoWithNullSource" )
    @NullSource
    @Order(2)
    public void testReverseDemoWithNullSource( String input ) {
        Assertions.assertEquals( null, s.reverse( input ), () -> "String is not null" );
        Assertions.assertNull( s.reverse( input ) );

    }

    @ParameterizedTest(name= "testReverseDemoWithEmptySource" )
    @EmptySource
    @Order(3)
    public void testReverseDemoWithEmptySource( String input ) {
        Assertions.assertEquals( "", s.reverse( input ), () -> "String is not empty" );

    }

    @ParameterizedTest(name = "testReverseDemoWithNullAndEmptySource")
    @NullAndEmptySource
    @Order(4)
    public void testReverseDemoWithNullAndEmptySource( String input ) {
        Assertions.assertEquals( input, s.reverse( input ), () -> "String is not empty or null" );

    }

    @ParameterizedTest(name = "csvSourceDemoTest")
    @CsvSource({"car,rac",
                "test,tset"})
    @Order(5)
    public void csvSourceDemoTest( String input, String expect ) {
        StringHelper s = new StringHelper();
        Assertions.assertEquals( expect, s.reverse( input ), () -> "String are not matching" );

    }
    @ParameterizedTest(name = "csvSourceDemoWithSingleQuoteTest")
    @CsvSource({"car,'my,car'",
            "test,tset"})
    @Order(6)
    public void csvSourceDemoWithSingleQuoteTest( String first, String second ) {

        Assertions.assertNotNull( first );
        Assertions.assertNotNull( second );
    }

    @RepeatedTest( 5 )
    @Order( 7 )
    public void simpleRepeatedTest(){
        Assertions.assertTrue( 0<5 );
    }

    @RepeatedTest( value=5,name="{displayName} - {currentRepetition} / {totalRepetitions}" )
    @DisplayName( "simpleRepeatedTest2" )
    @Order( 8 )
    public void simpleRepeatedTest2(){
        Assertions.assertTrue( 0<5 );
    }
}
