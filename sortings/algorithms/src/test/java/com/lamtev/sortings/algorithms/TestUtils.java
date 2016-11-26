package com.lamtev.sortings.algorithms;

import java.util.Random;

class TestUtils {

    static int[] generateArray(int n) {
        Random RANDOM = new Random(System.currentTimeMillis());
        int[] array = new int[n];
        for (int i = 0; i < n; ++i) {
            array[i] = i + 1;
        }
        for (int i = 0; i < n; ++i) {
            BinaryInsertionSort.swap(array, i, Math.abs(RANDOM.nextInt()) % n);
        }
        return array;
    }

}
