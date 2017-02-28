package com.recursion;

import java.util.List;

class BubbleSort {

    private BubbleSort() {
    }

    static List<Integer> sort(List<Integer> array) {

        if (array.size() == 1) {
            return array;
        }

        int tmp;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i - 1) > array.get(i)) {
                tmp = array.get(i - 1);
                array.set(i - 1, array.get(i));
                array.set(i, tmp);
            }
        }
        sort(array.subList(0, array.size() - 1));

        return array;
    }

}
