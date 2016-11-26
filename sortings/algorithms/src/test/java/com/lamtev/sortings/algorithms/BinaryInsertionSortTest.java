package com.lamtev.sortings.algorithms;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BinaryInsertionSortTest {

    @Test
    public void testSort() {
        int n = 100_000;
        int[] expectedArray = TestUtils.generateArray(n);
        int[] actualArray = expectedArray.clone();
        Arrays.sort(expectedArray);
        BinaryInsertionSort.sort(actualArray);
        assertTrue(Arrays.equals(expectedArray, actualArray));
    }

}