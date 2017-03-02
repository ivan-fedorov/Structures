package com.mergesort;

import java.util.List;

import static com.mergesort.Recursive.merge;

class Iterative {

    private Iterative() {
    }

    static List<Integer> mergeSort(List<Integer> list) {

        List<Integer> tmpList;

        if (list.isEmpty()) {
            return list;
        }

        int len = 2;

        while (len <= list.size()) {

            int count = list.size() / len;

            for (int i = 0; i < count; i++) {
                tmpList = merge(list.subList(i * len, i * len + (len / 2)), list.subList(i * len + (len / 2),
                        (i + 1) * len));
                for (int j = 0; j < len; j++) {
                    list.set(len * i + j, tmpList.get(j));
                }
            }
            len *= 2;
        }
        return list;
    }


}
