package com.maps;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"SameParameterValue", "unused"})
class LinearMap {

    private final int capacity;
    private List<Pair<Object, Object>> list;

    LinearMap(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            list.add(null);
        }
    }

    boolean put(Object key, Object value) {
        int nextIndex;
        if (key == null || value == null) {
            return false;
        }
        if (list.get(hash(key)) != null) {
            nextIndex = (hash(key) + 1) % capacity;
            while (nextIndex != hash(key)) {
                if (list.get(nextIndex) != null) {
                    nextIndex = (nextIndex + 1) % capacity;
                } else {
                    list.set(nextIndex, new Pair<>(key, value));
                    return true;
                }
            }
            return false;
        }
        list.set(hash(key), new Pair<>(key, value));
        return true;
    }

    Object getKey(Object key) {
        for (Pair<Object, Object> pair : list) {
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return null;
    }

    boolean deleteKey(Object key) {
        Pair<Object, Object> tmpPair;
        for (int i = 0; i < list.size(); i++) {
            tmpPair = list.get(i);
            if (tmpPair != null && tmpPair.getKey().equals(key)) {
                list.set(i, null);
                return true;
            }
        }
        return false;
    }

    private int hash(Object key) {
        return key.hashCode() % capacity;
    }
}
