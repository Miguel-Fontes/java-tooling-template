package br.com.miguelmf.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static br.com.miguelmf.example.Math.*;

@DisplayName("Math")
class MathTest {

    @Nested
    @DisplayName("Sum")
    class Sum {

        @Test
        @DisplayName("Should sum two values")
        void shouldSumTwoValues() {
            assertEquals(1, sum(0, 1));
            assertEquals(2, sum(1, 1));
            assertEquals(3, sum(1, 2));
            assertEquals(4, sum(2, 2));
            assertEquals(8, sum(4, 4));
            assertEquals(3000, sum(1500, 1500));
            assertEquals(0, sum(-100, 100));
            assertEquals(-200, sum(-100, -100));
        }

        @Test
        @DisplayName("The order of the factors should not alter the product")
        void sumOrderShouldNotAlterTheProduct() {
            assertEquals(1, sum(0, 1));
            assertEquals(1, sum(1, 0));

            assertEquals(15, sum(10, 5));
            assertEquals(15, sum(5, 10));

            assertEquals(30, sum(27, 3));
            assertEquals(30, sum(3, 27));

            assertEquals(92, sum(90, 2));
            assertEquals(92, sum(2, 90));

            assertEquals(-270, sum(-150, -120));
            assertEquals(-270, sum(-120, -150));
        }

    }

    @Nested
    @DisplayName("Subtract")
    class Subtract {

        @Test
        @DisplayName("Should subtract two values")
        void shouldSubtractTwoValues() {
            assertEquals(0, subtract(0,0));
            assertEquals(1, subtract(2,1));
            assertEquals(14, subtract(15,1));
            assertEquals(-1, subtract(1,2));
            assertEquals(-50, subtract(50,100));
            assertEquals(50, subtract(-50,-100));
        }

        @Test
        @DisplayName("The order of the factor should alter the product")
        void subtractionOrderShouldAlterTheProduct() {
            assertEquals(1, subtract(2,1));
            assertEquals(-1, subtract(1,2));

            assertEquals(5, subtract(10,5));
            assertEquals(-5, subtract(5,10));

            assertEquals(10, subtract(-10,-20));
            assertEquals(-10, subtract(-20,-10));
        }
    }

}