package com.maps;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log
class MyCustomList {

    private ArrayList<ArrayList<Integer>> mainArray;

    MyCustomList(int capacity) {
        mainArray = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            mainArray.add(new ArrayList<>());
        }
    }

    void add(int value) {
        ArrayList<Integer> tmpInt = mainArray.get(hashCode(value));
        tmpInt.add(value);
        mainArray.set(hashCode(value), tmpInt);
    }

    private int hashCode(int value) {
        return value % 1000;
    }

    List<Integer> getValue(int key) {
        if (key < 1000) {
            return mainArray.get(key);
        }
        return Collections.emptyList();
    }

    int getKey(int value) {
        for (int i = 0; i < mainArray.size(); i++) {
            if (mainArray.get(i).contains(value)) {
                return i;
            }
        }
        return -1;
    }
}
