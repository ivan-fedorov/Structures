package com.mergesort;

import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Log
class MergeTest {
    List<Integer> list = new LinkedList<>();

    @BeforeEach
    void setUp() {
        list.add(5);
        list.add(4);
        list.add(4);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(1);
        list.add(433);
        list.add(1);
    }


    @Test
    void recursiveVSiterative() {
        assertEquals(Recursive.mergeSort(list), Iterative.mergeSort(list));
    }


}