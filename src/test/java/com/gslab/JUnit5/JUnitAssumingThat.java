package com.gslab.JUnit5;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JUnitAssumingThat {
    @Test
    @Order( 1 )
    @DisplayName( "assumingThatWithBooleanCondition" )
    public void assumingThatWithBooleanCondition(){
        Assumptions.assumingThat("DEV".equals("DEV"),()-> {
            System.out.println("dev environment");
        } );
    }
    @Test
    @Order( 2 )
    @DisplayName( "assumingThatWithBooleanSupplierAndBooleanCondition" )
    public void assumingThatWithBooleanSupplierAndBooleanCondition(){
        Assumptions.assumingThat("DEV".equals("DEV"),()-> {
            System.out.println("dev environment");
        } );
    }
}
