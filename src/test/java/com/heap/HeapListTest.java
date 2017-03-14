package com.heap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.heap.HeapList.makeHeap;


class HeapListTest {
    private List<Integer> basicList;

    @BeforeEach
    void setUp() {
        basicList = new ArrayList<>();

        basicList.add(4);
        basicList.add(3);
        basicList.add(1);
        basicList.add(5);
        basicList.add(14);
        basicList.add(9);
        basicList.add(6);
        basicList.add(10);
        basicList.add(2);
        basicList.add(8);
        basicList.add(7);
        basicList.add(11);

    }

    @Test
    void test() {
        System.out.println(makeHeap(basicList).toString());
    }

}