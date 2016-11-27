package com.lamtev.sortings.algorithms;

import static com.lamtev.sortings.algorithms.util.Utils.swap;

public class BinaryInsertionSort {

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            int ikey = binarySearchForInsertionIndex(array, array[i], -1, i);
            for (int j = i - 1; j >= ikey; --j) {
                swap(array, j, j + 1);
            }
        }
        return array;
    }

    private static int binarySearchForInsertionIndex(int[] array, int key, int left, int right) {
        while (left < right - 1) {
            int mid = (left + right) >> 1;
            if (array[mid] < key) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

}
