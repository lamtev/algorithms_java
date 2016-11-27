package com.lamtev.sortings.algorithms;

public class ShiftInsertionSort {

    public static int[] sort(int[] array) {
        int length = array.length;
        int mid = length / 2;
        int left = mid;
        int right = mid;
        int[] sortedArray = new int[length];
        sortedArray[mid] = array[0];
        for (int i = 1; i < length; ++i) {
            int ikey = binarySearchForInsertionIndex(sortedArray, array[i], left - 1, right + 1);
            if (ikey == left) {
                if (left == 0) {
                    System.arraycopy(sortedArray, left, sortedArray, left + 1, right - left + 1);
                    sortedArray[ikey] = array[i];
                    ++right;
                } else {
                    sortedArray[ikey - 1] = array[i];
                    --left;
                }
            } else if (ikey > right) {
                if (right == length - 1) {
                    System.arraycopy(sortedArray, left, sortedArray, left - 1, right - left + 1);
                    sortedArray[ikey - 1] = array[i];
                    --left;
                } else {
                    sortedArray[ikey] = array[i];
                    ++right;
                }
            } else if (ikey - left <= right - ikey) {
                if (left > 0) {
                    System.arraycopy(sortedArray, left, sortedArray, left - 1, ikey - left);
                    sortedArray[ikey - 1] = array[i];
                    --left;
                } else {
                    System.arraycopy(sortedArray, ikey, sortedArray, ikey + 1, right - ikey + 1);
                    sortedArray[ikey] = array[i];
                    ++right;
                }
            } else if (ikey - left > right - ikey) {
                if (right >= length - 1) {
                    System.arraycopy(sortedArray, left, sortedArray, left - 1, ikey - left);
                    sortedArray[ikey-1] = array[i];
                    --left;
                } else {
                    System.arraycopy(sortedArray, ikey, sortedArray, ikey + 1, right - ikey + 1);
                    sortedArray[ikey] = array[i];
                    ++right;
                }
            }
        }
        System.arraycopy(sortedArray, 0, array, 0, sortedArray.length);
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
