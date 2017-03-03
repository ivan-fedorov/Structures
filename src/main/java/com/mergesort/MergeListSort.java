package com.mergesort;

import java.util.LinkedList;
import java.util.List;

class MergeListSort {

    private MergeListSort() {
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
