package com.lamtev.algorithms_java.sortings;

import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;

public class BubbleSortBenchmark {

    @Param({"1", "10", "100", "1000"})
    int size;

    int[] xs;

    @Setup
    public void setup() {
        xs = new int[size];
        for (int c = 0; c < size; c++) {
            xs[c] = c;
        }

    }

}
