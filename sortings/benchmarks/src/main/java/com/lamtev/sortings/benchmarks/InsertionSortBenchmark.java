package com.lamtev.sortings.benchmarks;

import com.lamtev.sortings.algorithms.InsertionSort;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class InsertionSortBenchmark {

    private int[] a;

    @Setup(value = Level.Invocation)
    public void setUpInvocation() {
        a = new int[] {1, 4, 8, 2, 5, 9};
    }

    @Benchmark
    public void measureBubbleSort(Blackhole bh) {
        bh.consume(InsertionSort.sort(a));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(InsertionSortBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
