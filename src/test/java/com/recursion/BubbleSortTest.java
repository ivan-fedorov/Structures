package com.recursion;

import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTest {

    @Test
    void test() {
        val arrayEtalon = new ArrayList<Integer>();
        arrayEtalon.add(1);
        arrayEtalon.add(2);
        arrayEtalon.add(3);
        arrayEtalon.add(4);
        arrayEtalon.add(5);

        val integers = new ArrayList<Integer>();
        integers.add(5);
        integers.add(4);
        integers.add(3);
        integers.add(2);
        integers.add(1);

        BubbleSort.sort(integers);

        assertArrayEquals(arrayEtalon.toArray(), integers.toArray());
    }

}