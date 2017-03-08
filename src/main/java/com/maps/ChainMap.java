package com.maps;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class ChainMap {

    private final int capacity;
    private List<List<Pair<Object, Object>>> list;

    ChainMap(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            list.add(new LinkedList<>());
        }
    }

    boolean put(Object key, Object value) {
        List<Pair<Object, Object>> tmpList;
        if (key == null || value == null) {
            return false;
        }
        tmpList = list.get(hash(key));
        tmpList.add(new Pair<>(key, value));
        list.set(hash(key), tmpList);
        return true;
    }

    Object getKey(Object key) {
        for (List<Pair<Object, Object>> pairList : list) {
            for (Pair<Object, Object> pair : pairList) {
                if (pair.getKey() == key) {
                    return pair.getValue();
                }
            }
        }
        return null;
    }

    boolean deleteKey(Object key) {
        for (List<Pair<Object, Object>> pairList : list) {
            for (int i = 0; i < pairList.size(); i++) {
                if (pairList.get(i).getKey() == key) {
                    pairList.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private int hash(Object key) {
        return key.hashCode() % capacity;
    }
}
