package com.recursion;

import java.util.List;

class BubbleSort {

    private BubbleSort() {
    }

    static List<Integer> sort(List<Integer> list) {

        if (list.size() == 1 || list.isEmpty()) {
            return list;
        }

        int tmp;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                tmp = list.get(i - 1);
                list.set(i - 1, list.get(i));
                list.set(i, tmp);
            }
        }
        sort(list.subList(0, list.size() - 1));

        return list;
    }

}
