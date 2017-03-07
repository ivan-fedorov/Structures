package com.fibonacci;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
class RecursiveFibonacciTest {
    @Test
    void fiboTest() {
        RecursiveFibonacci fibo = new RecursiveFibonacci();

        assertEquals(fibo.fibonacci(15), 610);
        assertEquals(fibo.fibonacci(11), 89);
        assertEquals(fibo.fibonacci(0), 0);
        assertEquals(fibo.fibonacci(-11), 0);
        assertEquals(fibo.fibonacci(300), -1287770608);
    }

}