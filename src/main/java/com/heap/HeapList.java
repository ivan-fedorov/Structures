package com.heap;

import java.util.List;

public class HeapList {

    private static int heapSize;

    public static List<Integer> makeHeap(List<Integer> list) {
        if (list.isEmpty() || list == null) {
            return list;
        }
        heapSize = list.size();
        if (heapSize > 1) {
            for (int i = list.size() / 2; i >= 0; i--) {
                heapify(list, i);
            }
        }
        return list;
    }

    private static void heapify(List<Integer> list, int i) {
        int l = left(i);
        int r = right(i);
        int max = i;
        if (l < heapSize && list.get(i) < list.get(l)) {
            max = l;
        }
        if (r < heapSize && list.get(max) < list.get(r)) {
            max = r;
        }
        if (i != max) {
            swap(list, i, max);
            heapify(list, max);
        }
    }

    private static int right(int i) {
        return 2 * i + 1;
    }

    private static int left(int i) {
        return 2 * i + 2;
    }

    private static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
