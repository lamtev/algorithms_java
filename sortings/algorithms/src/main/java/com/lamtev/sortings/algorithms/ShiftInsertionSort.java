package com.lamtev.sortings.algorithms;

public class ShiftInsertionSort {

    public static int[] sort(int[] array) {
        return array;
    }

    static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
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
