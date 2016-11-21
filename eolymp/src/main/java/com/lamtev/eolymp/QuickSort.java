package com.lamtev.eolymp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    private Scanner in;
    private PrintWriter out;
    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        new QuickSort().run();
    }

    public void run() {
        try {
            in = new Scanner(System.in);
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void solve() throws IOException {
        String[] sArr = in.nextLine().split(" ");
        int size = 0;
        int[] a = new int[sArr.length];
        for (String s : sArr) {
            a[size++] = Integer.parseInt(s);
        }
        randomizedQuicksort(a, 0, size - 1);
        println(a, 0, size - 1);
    }

    private static void randomizedQuicksort(int[] a, int p, int r) {
        if (p < r) {
            int q = randomizedPartition(a, p, r);
            randomizedQuicksort(a, p, q - 1);
            randomizedQuicksort(a, q + 1, r);
        }
    }

    private static int randomizedPartition(int[] a, int p, int r) {
        int i = Math.abs(random.nextInt()) % (r - p + 1) + p;
        swap(a, r, i);
        return partition(a, p, r);
    }

    private static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, ++i, r);
        return i;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void println(int[] a, int p, int r) {
        int n = a.length;
        for (int i = p; i <= r; ++i) {
            out.print(a[i]);
            if (i != n - 1) {
                out.print(" ");
            }
        }
        out.println();
    }

}