package com.mergesort;

import java.util.List;

import static com.mergesort.MergeListSort.merge;

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


}
