package com;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.LinkedList;

@Log
@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public class LinkedAndArrayListComparison {

    private LinkedAndArrayListComparison() {
    }

    public static void main(String[] args) {
        final int capacity1K = 1000;
        final int capacity1KK = 1_000_000;
        final int capacity10KK = 10_000_000;
        final String stringDelimiter = "\n LL: ";

        ArrayList<Integer> arrayList1K = new ArrayList<>(capacity1K);
        LinkedList<Integer> linkedList1K = new LinkedList<>();

        ArrayList<Integer> arrayList1KK = new ArrayList<>(capacity1KK);
        LinkedList<Integer> linkedList1KK = new LinkedList<>();

        ArrayList<Integer> arrayList10KK = new ArrayList<>(capacity10KK);
        LinkedList<Integer> linkedList10KK = new LinkedList<>();

        long alStart;
        long alStop;
        long llStart;
        long llStop;

        alStart = System.currentTimeMillis();
        for (int i = 0; i < capacity1K; i++) {
            arrayList1K.add(i, i);
        }
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        for (int i = 0; i < capacity1K; i++) {
            linkedList1K.add(i);
        }
        llStop = System.currentTimeMillis();


        log.info("Adding 1K elements:\n AL: " + (alStop - alStart) + stringDelimiter + (llStop - llStart) + "\n");

        alStart = System.currentTimeMillis();
        for (int i = 0; i < capacity1KK; i++) {
            arrayList1KK.add(i, i);
        }
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        for (int i = 0; i < capacity1KK; i++) {
            linkedList1KK.add(i);
        }
        llStop = System.currentTimeMillis();
        log.info("Adding 1KK elements:\n AL: " + (alStop - alStart) + stringDelimiter + (llStop - llStart) + "\n");


        alStart = System.currentTimeMillis();
        for (int i = 0; i < capacity10KK; i++) {
            arrayList10KK.add(i, i);
        }
        alStop = System.currentTimeMillis();

        llStart = System.currentTimeMillis();
        for (int i = 0; i < capacity10KK; i++) {
            linkedList10KK.add(i);
        }
        llStop = System.currentTimeMillis();
        log.info("Adding 10KK elements:\n AL: " + (alStop - alStart) + stringDelimiter + (llStop - llStart) + "\n");


        alStart = System.currentTimeMillis();
        arrayList1K.get(capacity1K / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList1K.get(capacity1K / 2);
        llStop = System.currentTimeMillis();
        log.info("SEARCHING MIDDLE INDEX on 1K elements:\n AL: " + (alStop - alStart) + stringDelimiter + (llStop - llStart) + "\n");


        alStart = System.currentTimeMillis();
        arrayList1KK.get(capacity1KK / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList1KK.get(capacity1KK / 2);
        llStop = System.currentTimeMillis();
        log.info("SEARCHING MIDDLE INDEX on 1KK elements:\n AL: " + (alStop - alStart) + stringDelimiter + (llStop - llStart) + "\n");


        alStart = System.currentTimeMillis();
        arrayList10KK.get(capacity10KK / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList10KK.get(capacity10KK / 2);
        llStop = System.currentTimeMillis();
        log.info("SEARCHING MIDDLE INDEX on 10KK elements:\n AL: " + (alStop - alStart) + stringDelimiter + (llStop - llStart) + "\n");

        alStart = System.currentTimeMillis();
        arrayList1K.remove(capacity1K / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList1K.remove(capacity1K / 2);
        llStop = System.currentTimeMillis();
        log.info("DELETING MIDDLE INDEX on 1K elements:\n AL: " + (alStop - alStart) + stringDelimiter + (llStop - llStart) + "\n");


        alStart = System.currentTimeMillis();
        arrayList1KK.remove(capacity1KK / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList1KK.remove(capacity1KK / 2);
        llStop = System.currentTimeMillis();
        log.info("DELETING MIDDLE INDEX on 1KK elements:\n AL: " + (alStop - alStart) + stringDelimiter + (llStop - llStart) + "\n");


        alStart = System.currentTimeMillis();
        arrayList10KK.remove(capacity10KK / 2);
        alStop = System.currentTimeMillis();
        llStart = System.currentTimeMillis();
        linkedList10KK.remove(capacity10KK / 2);
        llStop = System.currentTimeMillis();
        log.info("DELETING MIDDLE INDEX on 10KK elements:\n AL: " + (alStop - alStart) + stringDelimiter + (llStop - llStart) + "\n");

    }
}
