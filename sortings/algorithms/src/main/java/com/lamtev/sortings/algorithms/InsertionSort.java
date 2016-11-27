package com.lamtev.sortings.algorithms;

import static com.lamtev.sortings.algorithms.util.Utils.swap;

public class InsertionSort {

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            for (int j = i; j > 0 && array[j] < array[j - 1]; --j) {
                swap(array, j, j - 1);
            }
        }
        return array;
    }

}
