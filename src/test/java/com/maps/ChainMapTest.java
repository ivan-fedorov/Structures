package com.maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ChainMapTest {

    private ChainMap chainMap;

    @BeforeEach
    void setUp() {
        chainMap = new ChainMap(5);

        chainMap.put(1, 5);
        chainMap.put(1, 5);
        chainMap.put(2, 3);
        chainMap.put(1, 5);
        chainMap.put(1, 5);

    }

    @Test
    void test() {
        assertTrue(chainMap.put(3, 1));
        chainMap.deleteKey(2);
        assertTrue(chainMap.put(1, 1));
    }

}