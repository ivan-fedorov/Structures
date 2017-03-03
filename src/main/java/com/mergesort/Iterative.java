package com.mergesort;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import static com.mergesort.Recursive.merge;
class Iterative {

    private Iterative() {
    }

    static List<Integer> mergeSort(List<Integer> list) {

        Queue<List<Integer>> queue = new LinkedBlockingDeque<>();
        queue.add(list);
        List<Integer> tmpList;
        List<Integer> left;
        List<Integer> right;

        while (queue.size() != list.size()) {
            tmpList = queue.poll();
            if (tmpList.size() == 1) {
                queue.add(tmpList);
                continue;
            }
            left = tmpList.subList(0, tmpList.size() / 2);
            right = tmpList.subList(tmpList.size() / 2, tmpList.size());
            if (!left.isEmpty()) {
                queue.add(left);
            }
            if (!right.isEmpty()) {
                queue.add(right);
            }
        }

        while (queue.size() != 1) {
            left = queue.poll();
            right = queue.poll();
            queue.add(merge(left, right));
        }

        return queue.peek();
    }


}
