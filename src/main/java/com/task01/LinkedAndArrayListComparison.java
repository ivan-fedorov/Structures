package com.task01;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.String.*;

@Log
public class LinkedAndArrayListComparison {

    private static final String ARRAY_LIST_FASTER = "ArrayList faster";
    private static final String LINKED_LIST_FASTER = "LinkedList faster";

    private static long alStart;
    private static long alStop;
    private static long llStart;
    private static long llStop;

    private LinkedAndArrayListComparison() {
    }

    public static void main(String[] args) {
        final int capacity1K = 1000;
        final int capacity1KK = 1_000_000;
        final int capacity10KK = 10_000_000;

        ArrayList<Integer> arrayList1K = new ArrayList<>();
        LinkedList<Integer> linkedList1K = new LinkedList<>();

        ArrayList<Integer> arrayList1KK = new ArrayList<>();
        LinkedList<Integer> linkedList1KK = new LinkedList<>();

        ArrayList<Integer> arrayList10KK = new ArrayList<>();
        LinkedList<Integer> linkedList10KK = new LinkedList<>();

        addToEndList(capacity1K, arrayList1K, linkedList1K);
        addToEndList(capacity1KK, arrayList1KK, linkedList1KK);
        addToEndList(capacity10KK, arrayList10KK, linkedList10KK);

        arrayList1K = new ArrayList<>(capacity1K);
        linkedList1K = new LinkedList<>();

        arrayList1KK = new ArrayList<>(capacity1KK);
        linkedList1KK = new LinkedList<>();

        arrayList10KK = new ArrayList<>(capacity10KK);
        linkedList10KK = new LinkedList<>();

        addToBeginOfList(capacity1K, arrayList1K, linkedList1K);
        addToBeginOfList(capacity1KK, arrayList1KK, linkedList1KK);
        addToBeginOfList(capacity10KK, arrayList10KK, linkedList10KK);

        findElementByIndex(arrayList1K, linkedList1K, capacity1K / 2);
        findElementByIndex(arrayList1KK, linkedList1KK, capacity1KK / 2);
        findElementByIndex(arrayList10KK, linkedList10KK, capacity10KK / 2);

        deleteElementByIndex(arrayList1K, linkedList1K, capacity1K / 2);
        deleteElementByIndex(arrayList1KK, linkedList1KK, capacity1KK / 2);
        deleteElementByIndex(arrayList10KK, linkedList10KK, capacity10KK / 2);

    }

    private static void deleteElementByIndex(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList1K, int index) {
        alStart = System.currentTimeMillis();
        arrayList.remove(index);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList1K.remove(index);
        llStop = System.currentTimeMillis();
        log.info(format("DELETING %s INDEX on 1K elements:%n AL: %d ms %n LL: %d ms%n %s%n", index, alStop - alStart, llStop - llStart, checkFasterList(alStart, alStop, llStart, llStop)));

        checkFasterList(alStart, alStop, llStart, llStop);
    }

    private static void findElementByIndex(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList1K, int index) {
        alStart = System.currentTimeMillis();
        arrayList.get(index);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList1K.get(index);
        llStop = System.currentTimeMillis();
        log.info(format("SEARCHING %s INDEX on 1K elements:%n AL: %d ms %n LL: %d ms%n %s%n", index, alStop - alStart, llStop - llStart, checkFasterList(alStart, alStop, llStart, llStop)));
        checkFasterList(alStart, alStop, llStart, llStop);
    }

    private static void addToEndList(int capacity, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList) {
        alStart = System.currentTimeMillis();
        for (int i = 0; i < capacity; i++) {
            arrayList.add(i);
        }
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        for (int i = 0; i < capacity; i++) {
            linkedList.add(i);
        }
        llStop = System.currentTimeMillis();

        log.info(format("Adding %s elements to the end of list:%n AL: %d ms%n LL: %d ms%n %s%n", capacity, alStop - alStart, llStop - llStart, checkFasterList(alStart, alStop, llStart, llStop)));
        checkFasterList(alStart, alStop, llStart, llStop);
    }
    
    private static void addToBeginOfList(int capacity, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList) {
        alStart = System.currentTimeMillis();
        for (int i = 0; i < capacity; i++) {
            arrayList.add(0,i);
        }
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        for (int i = 0; i < capacity; i++) {
            linkedList.add(0,i);
        }
        llStop = System.currentTimeMillis();

        log.info(format("Adding %s elements to the beginning of list:%n AL: %d ms%n LL: %d ms%n %s%n", capacity, alStop - alStart, llStop - llStart, checkFasterList(alStart, alStop, llStart, llStop)));

    }

    private static String checkFasterList(long alStart, long alStop, long llStart, long llStop) {
        if ((alStop - alStart) < (llStop - llStart)) {
            return ARRAY_LIST_FASTER;
        } else {
            return LINKED_LIST_FASTER;
        }

    }


}
