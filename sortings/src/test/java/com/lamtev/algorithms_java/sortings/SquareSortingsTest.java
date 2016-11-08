package com.lamtev.algorithms_java.sortings;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class SquareSortingsTest {

    @Test
    public void testBubbleSort() {
        long[] expected = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        long[] array = new long[10];
        SquareSortings.bubbleSort(array);
        assertTrue(Arrays.equals(expected, array));
    }

}
