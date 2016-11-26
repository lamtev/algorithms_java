package com.lamtev.sortings.algorithms;

public class InsertionSort {

    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            for (int j = i; j > 0 && array[j] < array[j-1];--j) {
                swap(array, j, j-1);
            }
        }
        return array;
    }

    static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
