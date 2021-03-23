package com.gslab.JUnit5;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAssumeTrue {

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
    @DisplayName( "assumeTrueWithNoMessage" )
    public void assumeTrueWithNoMessage(){
        Assumptions.assumeTrue( "DEV".equals("DEV") );
        Assertions.assertEquals( 3,2+1 );
    }
    @Test
    @Order( 2 )
    @DisplayName( "assumeTrueWithMessage" )
    public void assumeTrueWithMessage(){
        Assumptions.assumeTrue( "DEV".equals("UAT"),"assumption failed!" );
        Assertions.assertEquals( 3,2+1 );
    }

    @Test
    @Order( 3 )
    @DisplayName( "assumeTrueWithSupplierMessage" )
    public void assumeTrueWithSupplierMessage(){
        Assumptions.assumeTrue( "DEV".equals("UAT"),()->"assumption failed!" );
        Assertions.assertEquals( 3,2+1 );
    }
    @Test
    @Order( 4 )
    @DisplayName( "assumeTrueWithBooleanSupplierNoMessage" )
    public void assumeTrueWithBooleanSupplierNoMessage(){
        Assumptions.assumeTrue(()-> "DEV".equals("DEV") );
        Assertions.assertEquals( 3,2+1 );
    }
    @Test
    @Order( 5 )
    @DisplayName( "assumeTrueWithBooleanSupplierAndMessage" )
    public void assumeTrueWithBooleanSupplierAndMessage(){
        Assumptions.assumeTrue( ()->"DEV".equals("UAT"),"assumption failed!" );
        Assertions.assertEquals( 3,2+1 );
    }

    @Test
    @Order( 6 )
    @DisplayName( "assumeTrueWithBooleanSupplierAndSupplierMessage" )
    public void assumeTrueWithBooleanSupplierAndSupplierMessage(){
        Assumptions.assumeTrue(()-> "DEV".equals("UAT"),()->"assumption failed!" );
        Assertions.assertEquals( 3,2+1 );
    }
}
