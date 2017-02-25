package com.task01;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.LinkedList;

import static java.lang.String.*;

@Log
@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class LinkedAndArrayListComparison {

    private static final String ARRAY_LIST_FASTER = "ArrayList faster";
    private static final String LINKED_LIST_FASTER = "LinkedList faster";

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

        long alStart;
        long alStop;
        long llStart;
        long llStop;



        alStart = System.currentTimeMillis();
        for (int i = 0; i < capacity1K; i++) {
            arrayList1K.add(i);
        }
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        for (int i = 0; i < capacity1K; i++) {
            linkedList1K.add(i);
        }
        llStop = System.currentTimeMillis();


        log.info(format("Adding 1K elements:%n AL: %d ms%n LL: %d ms%n", alStop - alStart, llStop - llStart));

        alStart = System.currentTimeMillis();
        for (int i = 0; i < capacity1KK; i++) {
            arrayList1KK.add(i);
        }
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        for (int i = 0; i < capacity1KK; i++) {
            linkedList1KK.add(i);
        }
        llStop = System.currentTimeMillis();
        log.info(format("Adding 1KK elements:%n AL: %d ms %n LL: %d ms%n", alStop - alStart, llStop - llStart));

        checkFasterList(alStart, alStop, llStart, llStop);


        alStart = System.currentTimeMillis();
        for (int i = 0; i < capacity10KK; i++) {
            arrayList10KK.add(i);
        }
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        for (int i = 0; i < capacity10KK; i++) {
            linkedList10KK.add(i);
        }
        llStop = System.currentTimeMillis();
        log.info(format("Adding 10K elements:%n AL: %d ms%n LL: %d ms%n", alStop - alStart, llStop - llStart));

        checkFasterList(alStart, alStop, llStart, llStop);


        alStart = System.currentTimeMillis();
        arrayList1K.get(capacity1K / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList1K.get(capacity1K / 2);
        llStop = System.currentTimeMillis();
        log.info(format("SEARCHING MIDDLE INDEX on 1K elements:%n AL: %d ms %n LL: %d ms%n", alStop - alStart, llStop - llStart));

        checkFasterList(alStart, alStop, llStart, llStop);


        alStart = System.currentTimeMillis();
        arrayList1KK.get(capacity1KK / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList1KK.get(capacity1KK / 2);
        llStop = System.currentTimeMillis();
        log.info(format("SEARCHING MIDDLE INDEX on 1KK elements:%n AL: %d ms %n LL: %d ms%n", alStop - alStart, llStop - llStart));

        checkFasterList(alStart, alStop, llStart, llStop);


        alStart = System.currentTimeMillis();
        arrayList10KK.get(capacity10KK / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList10KK.get(capacity10KK / 2);
        llStop = System.currentTimeMillis();
        log.info(format("SEARCHING MIDDLE INDEX on 10KK elements:%n AL: %d ms %n LL: %d ms%n", alStop - alStart, llStop - llStart));

        checkFasterList(alStart, alStop, llStart, llStop);


        alStart = System.currentTimeMillis();
        arrayList1K.remove(capacity1K / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList1K.remove(capacity1K / 2);
        llStop = System.currentTimeMillis();
        log.info(format("DELETING MIDDLE INDEX on 1K elements:%n AL: %d ms %n LL: %d ms%n", alStop - alStart, llStop - llStart));

        checkFasterList(alStart, alStop, llStart, llStop);


        alStart = System.currentTimeMillis();
        arrayList1KK.remove(capacity1KK / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList1KK.remove(capacity1KK / 2);
        llStop = System.currentTimeMillis();
        log.info(format("DELETING MIDDLE INDEX on 1KK elements:%n AL: %d ms %n LL: %d ms%n", alStop - alStart, llStop - llStart));

        checkFasterList(alStart, alStop, llStart, llStop);

        alStart = System.currentTimeMillis();
        arrayList10KK.remove(capacity10KK / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList10KK.remove(capacity10KK / 2);
        llStop = System.currentTimeMillis();
        log.info(format("DELETING MIDDLE INDEX on 10KK elements:%n AL: %d ms %n LL: %d ms%n", alStop - alStart, llStop - llStart));

        checkFasterList(alStart, alStop, llStart, llStop);
    }

    private static void checkFasterList(long alStart, long alStop, long llStart, long llStop) {
        if ((alStop - alStart) < (llStop - llStart)) {
            log.info(ARRAY_LIST_FASTER);
        } else {
            log.info(LINKED_LIST_FASTER);
        }
    }
}
