package com.fibonacci;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import static com.fibonacci.RecursiveFibonacci.fibonacci;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
class RecursiveFibonacciTest {
    @Test
    void fiboTest() {
        assertEquals(fibonacci(15), 610);
        assertEquals(fibonacci(11), 89);
        assertEquals(fibonacci(0), 0);
        assertEquals(fibonacci(-11), -11);
    }

}