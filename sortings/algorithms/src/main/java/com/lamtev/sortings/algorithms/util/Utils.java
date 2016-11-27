package com.lamtev.sortings.algorithms.util;

import java.util.Random;

public class Utils {

    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static int[] generateArray(int arrayLength) {
        int[] array = new int[arrayLength];
        for (int i = 0; i < arrayLength; ++i) {
            array[i] = i;
        }
        for (int i = 0; i < arrayLength; ++i) {
            swap(array, i, Math.abs(RANDOM.nextInt()) % arrayLength);
        }
        return array;
    }

}
