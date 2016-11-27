package com.lamtev.sortings.algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ShiftInsertionSortTest {

    @Test
    public void testSort() {
        int arrayLength = 100_000;
        int numberOfTests = 10;
        for (int i = 0; i < numberOfTests; ++i) {
            int[] expectedArray = TestUtils.generateArray(arrayLength);
            int[] actualArray = expectedArray.clone();
            Arrays.sort(expectedArray);
            ShiftInsertionSort.sort(actualArray);
            assertTrue(Arrays.equals(expectedArray, actualArray));
        }
    }


}