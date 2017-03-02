package com.mergesort;

import java.util.LinkedList;
import java.util.List;

class Recursive {
    private Recursive() {
    }

    static List<Integer> mergeSort(List<Integer> list) {

        if (list.size() == 1 || list.isEmpty()) {
            return list;
        }

        int half = list.size() / 2;

        List<Integer> left = mergeSort(list.subList(0, half));
        List<Integer> right = mergeSort(list.subList(half, list.size()));

        return merge(left, right);
    }

    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> resultList = new LinkedList<>();
        List<Integer> localLeft = left;
        List<Integer> localRight = right;

        while (!localLeft.isEmpty() && !localRight.isEmpty()) {
            if (localLeft.get(0) <= localRight.get(0)) {
                resultList.add(localLeft.get(0));
                localLeft = localLeft.subList(1, localLeft.size());
            } else {
                resultList.add(localRight.get(0));
                localRight = localRight.subList(1, localRight.size());
            }
        }
        if (!localLeft.isEmpty()) {
            resultList.addAll(localLeft);
        }
        if (!localRight.isEmpty()) {
            resultList.addAll(localRight);
        }
        return resultList;
    }
}
