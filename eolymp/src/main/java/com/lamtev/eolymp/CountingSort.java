package com.lamtev.eolymp;

import java.io.*;
import java.util.StringTokenizer;


public class CountingSort {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new CountingSort().run();
    }

    public void run() {
        try {
            in = new FastScanner();
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void solve() throws IOException {
        int numberOfElements = in.nextInt();
        int count = 0;
        int[] arr = new int[numberOfElements];

        while (count < numberOfElements) {
            arr[count++] = in.nextInt();
        }
        printSorted(arr);
    }

    private void printSorted(int[] arr) {
        MinMax minMax = findMinMax(arr);
        int min = minMax.min();
        int[] a = new int[minMax.max() - min + 1];
        for (int anArr : arr) {
            a[anArr - min]++;
        }
        for (int i = 0; i < a.length; ++i) {
            while (a[i]-- != 0) {
                out.print(i + min + " ");
            }
        }
    }

    private MinMax findMinMax(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int anArr : arr) {
            if (anArr < min) {
                min = anArr;
            }
            if (anArr > max) {
                max = anArr;
            }
        }
        return new MinMax(min, max);
    }

    private class MinMax {

        private int min;
        private int max;

        MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        int min() {
            return min;
        }

        int max() {
            return max;
        }

    }

    private class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }

}