package com.mergesort;

import java.util.LinkedList;
import java.util.List;

import static com.mergesort.MergeListSort.merge;
class Iterative {

    private Iterative() {
    }

    static List<Integer> mergeSort(List<Integer> list) {

        if (list.size() == 1 || list.isEmpty()) {
            return list;
        }

        List<List<Integer>> quededList = new LinkedList<>();
        quededList.add(list);
        List<Integer> tmpList;
        List<Integer> left;
        List<Integer> right;

        while (quededList.size() != list.size()) {
            tmpList = quededList.remove(0);
            if (tmpList.size() == 1) {
                quededList.add(tmpList);
                continue;
            }
            left = tmpList.subList(0, tmpList.size() / 2);
            right = tmpList.subList(tmpList.size() / 2, tmpList.size());
            if (!left.isEmpty()) {
                quededList.add(left);
            }
            if (!right.isEmpty()) {
                quededList.add(right);
            }
        }

        while (quededList.size() != 1) {
            left = quededList.remove(0);
            right = quededList.remove(0);
            quededList.add(merge(left, right));
        }

        return quededList.get(0);
    }


}
