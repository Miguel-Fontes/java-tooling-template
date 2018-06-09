package br.com.miguelmf.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;

import static br.com.miguelmf.example.Math.*;

@DisplayName("Math")
class MathTest {

    private Math math;

    @BeforeEach
    void setup() {
        math = Math.newInstance();
    }

    @Test
    @DisplayName("Should create a new instance")
    void shouldCreateANewInstance() {
        assertNotNull(Math.newInstance());
    }

    @Nested
    @DisplayName("Sum")
    class Sum {

        @Test
        @DisplayName("Should sum two values")
        void shouldSumTwoValues() {
            assertEquals(1, math.sum(0, 1));
            assertEquals(2, math.sum(1, 1));
            assertEquals(3, math.sum(1, 2));
            assertEquals(4, math.sum(2, 2));
            assertEquals(8, math.sum(4, 4));
            assertEquals(3000, math.sum(1500, 1500));
            assertEquals(0, math.sum(-100, 100));
            assertEquals(-200, math.sum(-100, -100));
        }

        @Test
        @DisplayName("The order of the factors should not alter the product")
        void sumOrderShouldNotAlterTheProduct() {
            assertEquals(1, math.sum(0, 1));
            assertEquals(1, math.sum(1, 0));

            assertEquals(15, math.sum(10, 5));
            assertEquals(15, math.sum(5, 10));

            assertEquals(30, math.sum(27, 3));
            assertEquals(30, math.sum(3, 27));

            assertEquals(92, math.sum(90, 2));
            assertEquals(92, math.sum(2, 90));

            assertEquals(-270, math.sum(-150, -120));
            assertEquals(-270, math.sum(-120, -150));
        }

    }

    @Nested
    @DisplayName("Subtract")
    class Subtract {

        @Test
        @DisplayName("Should subtract two values")
        void shouldSubtractTwoValues() {
            assertEquals(0, math.subtract(0, 0));
            assertEquals(1, math.subtract(2, 1));
            assertEquals(14, math.subtract(15, 1));
            assertEquals(-1, math.subtract(1, 2));
            assertEquals(-50, math.subtract(50, 100));
            assertEquals(50, math.subtract(-50, -100));
        }

        @Test
        @DisplayName("The order of the factor should alter the product")
        void subtractionOrderShouldAlterTheProduct() {
            assertEquals(1, math.subtract(2, 1));
            assertEquals(-1, math.subtract(1, 2));

            assertEquals(5, math.subtract(10, 5));
            assertEquals(-5, math.subtract(5, 10));

            assertEquals(10, math.subtract(-10, -20));
            assertEquals(-10, math.subtract(-20, -10));
        }
    }

    @Nested
    @DisplayName ("Register")
    class Register {

        @Test
        @DisplayName("Should register the number of operations")
        void shouldRegisterTheNumberOfOperations() {
            IntStream.range(0, 30)
                .forEach(x -> math.sum(x, x));

            assertEquals(30, math.getNumberOfOperations());;
        }
    }

}