package com.lamtev.sortings.algorithms;

import java.util.Random;

import static com.lamtev.sortings.algorithms.util.Utils.swap;

public class RandomThreeWayPartitionQuickSort {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = Math.abs(RANDOM.nextInt()) % (right - left + 1) + left;
            int x = array[pivot];
            int j = left;
            int q = left;
            swap(array, left, pivot);
            for (int k = left + 1; k <= right; k++) {
                if (array[k] < x) {
                    swap(array, k, ++j);
                } else if (array[k] == x) {
                    swap(array, k, ++j);
                    swap(array, ++q, j);
                }
            }
            int i = j;
            for (int k = left; k <= q; k++) {
                swap(array, j--, k);
            }
            sort(array, left, j);
            sort(array, i + 1, right);
        }
    }

}
