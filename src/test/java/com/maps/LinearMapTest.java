package com.maps;

import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Log
class LinearMapTest {
    private LinearMap linearMap;

    @BeforeEach
    void setUp() {
        linearMap = new LinearMap(5);

        linearMap.put(1, 5);
        linearMap.put(1, 5);
        linearMap.put(2, 3);
        linearMap.put(1, 5);
        linearMap.put(1, 5);

    }

    @Test
    void test() {
        assertFalse(linearMap.put(3, 1));
        linearMap.deleteKey(2);
        assertTrue(linearMap.put(1, 1));
    }

}