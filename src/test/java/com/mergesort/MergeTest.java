package com.mergesort;

import lombok.extern.java.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Log
@SuppressWarnings("Duplicates")
class MergeTest {
    private final static int LIST_SIZE5K = 5000;
    private final static int LIST_SIZE20K = 20000;
    private final static int LIST_SIZE100 = 100;
    private List<Integer> list;
    private Random random;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
        random = new Random();
    }

    @Test
    void emptyListTest() {
        LinkedList<Integer> list = new LinkedList<>();
        assertThat(Iterative.mergeSort(list), is(list));
    }

    @Test
    void test5k() {

        for (int i = 0; i < LIST_SIZE5K; i++) {
            list.add(random.nextInt(LIST_SIZE5K));
        }

        long recTime = System.currentTimeMillis();
        List<Integer> recursive = Recursive.mergeSort(list);
        recTime = System.currentTimeMillis() - recTime;

        long iteTime = System.currentTimeMillis();
        List<Integer> iterative = Iterative.mergeSort(list);
        iteTime = System.currentTimeMillis() - iteTime;
        log.info(String.format("%d elements%nRECURSIVE: %d ms%nITERATIVE: %d ms", LIST_SIZE5K, recTime, iteTime));

        assertEquals(recursive, iterative);
    }

    @Test
    void test20k() {

        for (int i = 0; i < LIST_SIZE20K; i++) {
            list.add(random.nextInt(LIST_SIZE20K));
        }

        long recTime = System.currentTimeMillis();
        List<Integer> recursive = Recursive.mergeSort(list);
        recTime = System.currentTimeMillis() - recTime;

        long iteTime = System.currentTimeMillis();
        List<Integer> iterative = Iterative.mergeSort(list);
        iteTime = System.currentTimeMillis() - iteTime;
        log.info(String.format("%d elements%nRECURSIVE: %d ms%nITERATIVE: %d ms", LIST_SIZE20K, recTime, iteTime));

        assertEquals(recursive, iterative);
    }

    @Test
    void test100() {

        for (int i = 0; i < LIST_SIZE100; i++) {
            list.add(random.nextInt(LIST_SIZE100));
        }

        long recTime = System.currentTimeMillis();
        List<Integer> recursive = Recursive.mergeSort(list);
        recTime = System.currentTimeMillis() - recTime;

        long iteTime = System.currentTimeMillis();
        List<Integer> iterative = Iterative.mergeSort(list);
        iteTime = System.currentTimeMillis() - iteTime;
        log.info(String.format("%d elements%nRECURSIVE: %d ms%nITERATIVE: %d ms", LIST_SIZE100, recTime, iteTime));

        assertEquals(recursive, iterative);


    }


}