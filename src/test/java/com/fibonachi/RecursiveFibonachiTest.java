package com.fibonachi;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import static com.fibonachi.RecursiveFibonachi.fibonachi;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Log
class RecursiveFibonachiTest {
    @Test
    void fiboTest() {
        assertEquals(fibonachi(15), 610);
        assertEquals(fibonachi(11), 89);
        assertEquals(fibonachi(0), 0);
    }

}