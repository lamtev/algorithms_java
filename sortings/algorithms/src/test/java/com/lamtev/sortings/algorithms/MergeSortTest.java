package com.lamtev.sortings.algorithms;

import org.junit.Test;

import java.util.Arrays;

import static com.lamtev.sortings.algorithms.util.Utils.generateArray;
import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void testSort() {
        int arrayLength = 100_000;
        int numberOfTests = 10;
        for (int i = 0; i < numberOfTests; ++i) {
            int[] expectedArray = generateArray(arrayLength);
            int[] actualArray = expectedArray.clone();
            Arrays.sort(expectedArray);
            MergeSort.sort(actualArray);
            assertTrue(Arrays.equals(expectedArray, actualArray));
        }
    }

}