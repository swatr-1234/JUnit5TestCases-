package com.gslab.JUnit5;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAssumeFalse {

    @BeforeEach
    public void setup( TestInfo testInfo ) {
        System.out.println("Start..." + testInfo.getDisplayName());
    }
    @AfterEach
    public void tearDown(TestInfo testInfo) {
        System.out.println("End..." + testInfo.getDisplayName());
    }

    @Test
    @Order( 1 )
    @DisplayName( "assumeFalseWithNoMessage" )
    public void assumeFalseWithNoMessage(){
        Assumptions.assumeFalse( "DEV".equals("DEV") );
        Assertions.assertEquals( 3,2+1 );
    }
    @Test
    @Order( 2 )
    @DisplayName( "assumeFalseWithMessage" )
    public void assumeFalseWithMessage(){
        Assumptions.assumeFalse( "DEV".equals("UAT"),"assumption failed!" );
        Assertions.assertEquals( 3,2+1 );
    }

    @Test
    @Order( 3 )
    @DisplayName( "assumeFalseWithSupplierMessage" )
    public void assumeFalseWithSupplierMessage(){
        Assumptions.assumeFalse( "DEV".equals("UAT"),()->"assumption failed!" );
        Assertions.assertEquals( 3,2+1 );
    }
    @Test
    @Order( 4 )
    @DisplayName( "assumeFalseWithBooleanSupplierNoMessage" )
    public void assumeFalseWithBooleanSupplierNoMessage(){
        Assumptions.assumeFalse(()-> "DEV".equals("DEV") );
        Assertions.assertEquals( 3,2+1 );
    }
    @Test
    @Order( 5 )
    @DisplayName( "assumeFalseWithBooleanSupplierAndMessage" )
    public void assumeFalseWithBooleanSupplierAndMessage(){
        Assumptions.assumeFalse( ()->"DEV".equals("UAT"),"assumption failed!" );
        Assertions.assertEquals( 3,2+1 );
    }

    @Test
    @Order( 6 )
    @DisplayName( "assumeFalseWithBooleanSupplierAndSupplierMessage" )
    public void assumeFalseWithBooleanSupplierAndSupplierMessage(){
        Assumptions.assumeFalse(()-> "DEV".equals("UAT"),()->"assumption failed!" );
        Assertions.assertEquals( 3,2+1 );
    }
}
