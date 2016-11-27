package com.lamtev.sortings.algorithms;

import java.util.Random;

import static com.lamtev.sortings.algorithms.util.Utils.swap;

public class RandomPartitionQuickSort {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static int[] sort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int left, int right) {
        if (left < right) {
            int q = randomPartition(array, left, right);
            sort(array, left, q - 1);
            sort(array, q + 1, right);
        }
    }

    private static int randomPartition(int[] array, int left, int right) {
        int i = Math.abs(RANDOM.nextInt()) % (right - left + 1) + left;
        swap(array, right, i);
        return partition(array, left, right);
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
