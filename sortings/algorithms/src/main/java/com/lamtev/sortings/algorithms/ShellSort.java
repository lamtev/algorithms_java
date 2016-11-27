package com.lamtev.sortings.algorithms;

import static com.lamtev.sortings.algorithms.util.Utils.swap;

public class ShellSort {

    public static int[] sort(int[] array) {
        int n = array.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && array[j] < array[j - h]; j -= h) {
                    swap(array, j, j - h);
                }
            }
            h /= 3;
        }
        return array;
    }

}
