package com.fibonacci;

class RecursiveFibonacci {

    private int[] cache = new int[9999];

    RecursiveFibonacci() {
        cache[1] = 1;
    }

    int fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }

        if (cache[n] != 0) {
            return cache[n];
        }

        cache[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return cache[n];
    }

}
