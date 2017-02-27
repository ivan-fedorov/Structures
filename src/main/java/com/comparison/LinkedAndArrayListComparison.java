package com.comparison;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.String.format;

@Log
public class LinkedAndArrayListComparison {

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

        arrayList1K = new ArrayList<>();
        linkedList1K = new LinkedList<>();

        arrayList1KK = new ArrayList<>();
        linkedList1KK = new LinkedList<>();

        addToBeginOfList(capacity1K, arrayList1K, linkedList1K);
        addToBeginOfList(capacity1KK, arrayList1KK, linkedList1KK);

        findElementByIndex(arrayList1K, linkedList1K, capacity1K / 2);
        findElementByIndex(arrayList1KK, linkedList1KK, capacity1KK / 2);
        findElementByIndex(arrayList10KK, linkedList10KK, capacity10KK / 2);

        deleteElementByIndex(arrayList1K, linkedList1K, capacity1K / 2);
        deleteElementByIndex(arrayList1KK, linkedList1KK, capacity1KK / 2);
        deleteElementByIndex(arrayList10KK, linkedList10KK, capacity10KK / 2);

    }

    private static void deleteElementByIndex(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList1K, int index) {
        alStart = System.nanoTime();
        arrayList.remove(index);
        alStop = System.nanoTime();
        llStart = System.nanoTime();
        linkedList1K.remove(index);
        llStop = System.nanoTime();
        long alValue = alStop - alStart;
        long llValue = llStop - llStart;
        log.info(format("DELETING %s INDEX on %d elements:%n AL: %d ms %n LL: %d ms%n %s%n",
                index, arrayList.size() + 1, alValue, llValue, checkFasterList(alValue, llValue)));
    }

    private static void findElementByIndex(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList1K, int index) {
        alStart = System.nanoTime();
        arrayList.get(index);
        alStop = System.nanoTime();
        llStart = System.nanoTime();
        linkedList1K.get(index);
        llStop = System.nanoTime();
        long alValue = alStop - alStart;
        long llValue = llStop - llStart;

        log.info(format("SEARCHING %s INDEX on %d elements:%n AL: %d ns %n LL: %d ns%n %s%n",
                index,  arrayList.size() + 1, alValue, llValue, checkFasterList(alValue, llValue)));
    }

    private static void addToEndList(int capacity, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList) {
        alStart = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            arrayList.add(i);
        }
        alStop = System.nanoTime();
        llStart = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            linkedList.add(i);
        }
        llStop = System.nanoTime();

        long alValue = alStop - alStart;
        long llValue = llStop - llStart;

        log.info(format("Adding %s elements to the end of list:%n AL: %d ns%n LL: %d ns%n %s%n",
                arrayList.size(), alValue, llValue, checkFasterList(alValue, llValue)));
    }
    
    private static void addToBeginOfList(int capacity, ArrayList<Integer> arrayList, LinkedList<Integer> linkedList) {
        alStart = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            arrayList.add(0,i);
        }
        alStop = System.nanoTime();
        llStart = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            linkedList.add(0,i);
        }
        llStop = System.nanoTime();

        long alValue = alStop - alStart;
        long llValue = llStop - llStart;

        log.info(format("Adding %s elements to the beginning of list:%n AL: %d ns%n LL: %d ns%n %s%n",
                arrayList.size(), alValue, llValue, checkFasterList(alValue, llValue)));

    }

    private static String checkFasterList(long alValue, long llValue) {
        if (alValue < llValue) {
            return "ArrayList faster";
        } else if (alValue > llValue) {
            return "LinkedList faster";
        } else {
            return "Lists are equals";
        }

    }
}
