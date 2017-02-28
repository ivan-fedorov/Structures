package com.recursion;

import lombok.extern.java.Log;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

@Log
class BubbleSortTest {

    @Test
    void test() {

        val integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(4);
        integers.add(13);
        integers.add(3);
        integers.add(3);
        integers.add(2);
        integers.add(4);
        integers.add(1);
        integers.add(2);
        integers.add(2);
        integers.add(1);

        BubbleSort.sort(integers);

        log.info(integers.toString());

    }

}