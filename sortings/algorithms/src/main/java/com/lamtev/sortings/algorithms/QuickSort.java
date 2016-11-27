package com.lamtev.sortings.algorithms;

import static com.lamtev.sortings.algorithms.util.Utils.swap;

public class QuickSort {

    public static int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            int q = partition(array, left, right);
            sort(array, left, q - 1);
            sort(array, q + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            if (array[j] <= pivot) {
                swap(array, ++i, j);
            }
        }
        swap(array, ++i, right);
        return i;
    }

}
