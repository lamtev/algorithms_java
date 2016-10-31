package com.lamtev.algorithms_java.lab1;

import java.io.*;
import java.util.StringTokenizer;

public class GoHeap {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new GoHeap().run();
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

    }

    private class Heap {

        private int size = 0;
        private static final int DEFAULT_CAPACITY = 10;
        private int[] heap = new int[DEFAULT_CAPACITY];

        public void insert(int element) {

        }

        public int extract() {
            return 0;
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
