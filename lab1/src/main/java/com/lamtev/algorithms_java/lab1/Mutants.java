package com.lamtev.algorithms_java.lab1;

import java.io.*;
import java.util.StringTokenizer;

public class Mutants {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new Mutants().run();
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
        int n = in.nextInt();
        CutMap buf = new CutMap();
        for (int i = 0; i < n; ++i) {
            buf.add(in.nextInt(), 1);
        }
        int m = in.nextInt();
        for (int i = 0; i < m; ++i) {
            out.println(buf.get(in.nextInt()));
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

    private class CutMap {

        private int[] keys;
        private int[] values;
        private int size;

        CutMap() {
            keys = new int[100000];
            values = new int[10000];
            size = 0;
        }

        void add(int key, int value) {
            if (size != 0 && key == keys[size-1]) {
                values[size-1] += value;
            } else {
                keys[size] = key;
                values[size++] += value;
            }
        }

        int get(int key) {
            int index = binarySearch(keys, key);
            if (index != -1) {
                return values[index];
            }
            return 0;
        }

        private int binarySearch(int[] a, int key) {
            int index = binarySearchForInsertionIndex(a, key);
            if (a[index] == key) {
                return index;
            }
            return -1;
        }

        private int binarySearchForInsertionIndex(int[] a, int key) {
            int left = -1;
            int right = size;
            while (left < right - 1) {
                int mid = (left + right) >> 1;
                if (a[mid] < key) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            return right;
        }

    }

}
