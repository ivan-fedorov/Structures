package com.maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MapOfMapsTest {
    MapOfMaps map;

    @BeforeEach
    void setUp() {
        map = new MapOfMaps();
        map.addData("North America", "USA", "Atlanta");
        map.addData("North America", "USA", "Mountain View");
        map.addData("Asia", "India", "Bangalore");
        map.addData("Asia", "China", "Shanghai");
        map.addData("Africa", "Egypt", "Cairo");
    }

    @Test
    void test() {
        map.printMap();
    }

}