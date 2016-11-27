package com.lamtev.sortings.algorithms;

public class MergeSort {

    public static int[] sort(int[] array) {
        sort(array, new int[array.length], 0, array.length - 1);
        return array;
    }

    private static void sort(int[] array, int[] buffer, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            sort(array, buffer, left, mid);
            sort(array, buffer, mid + 1, right);
            merge(array, buffer, left, mid, right);
        }
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        System.arraycopy(array, left, temp, left, right + 1 - left);
        int p = left;
        int q = mid + 1;
        for (int i = left; i <= right; i++) {
            if (p > mid) {
                array[i] = temp[q++];
            } else if (q > right) {
                array[i] = temp[p++];
            } else if (temp[p] <= temp[q]) {
                array[i] = temp[p++];
            } else {
                array[i] = temp[q++];
            }
        }

    }
}
