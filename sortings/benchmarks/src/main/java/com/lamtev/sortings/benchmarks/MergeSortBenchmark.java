package com.lamtev.sortings.benchmarks;

import com.lamtev.sortings.algorithms.MergeSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

import static com.lamtev.sortings.algorithms.util.Utils.generateArray;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MergeSortBenchmark {

    private int[] array;

    @Param({"1000", "10000", "100000"})
    private int arrayLength;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        array = generateArray(arrayLength);
    }

    @Benchmark
    public void measureMergeSort(Blackhole bh) {
        bh.consume(MergeSort.sort(array));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MergeSortBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
