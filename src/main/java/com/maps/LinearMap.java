package com.maps;

import java.util.ArrayList;
import java.util.List;

public class LinearMap {

    private List<Object> list;
    private int capacity;

    LinearMap(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>(capacity);
    }

    void put(Object value) {


    }

    Object get(int key) {
        return new Object();
    }

    boolean delete(Object value) {

        return false;
    }

    private int hash(Object value) {
        return (int) (Math.random() * capacity);
    }
}
