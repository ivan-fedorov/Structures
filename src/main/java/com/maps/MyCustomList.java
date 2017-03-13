package com.maps;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log
class MyCustomList {

    private ArrayList<ArrayList<Integer>> mainArrayList;

    MyCustomList(int capacity) {
        mainArrayList = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            mainArrayList.add(new ArrayList<>());
        }
    }

    void add(int value) {
        ArrayList<Integer> tmpInt = mainArrayList.get(hashCode(value));
        tmpInt.add(value);
        mainArrayList.set(hashCode(value), tmpInt);
    }

    private int hashCode(int value) {
        return value % 1000;
    }

    List<Integer> getValue(int key) {
        if (key < 1000) {
            return mainArrayList.get(key);
        }
        return Collections.emptyList();
    }

    int getKey(int value) {
        for (int i = 0; i < mainArrayList.size(); i++) {
            if (mainArrayList.get(i).contains(value)) {
                return i;
            }
        }
        return -1;
    }
}
