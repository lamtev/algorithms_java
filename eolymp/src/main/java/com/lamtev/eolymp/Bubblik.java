package com.lamtev.eolymp;

import java.io.*;
import java.util.StringTokenizer;

public class Bubblik {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new Bubblik().run();
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
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        out.println(sort(a));
    }

    private int sort(int[] a) {
        int comparisons = 0;
        int i = 0;
        int n = a.length;
        boolean wasSwap = true;
        while (wasSwap) {
            wasSwap = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) {
                    swap(a, j, j + 1);
                    wasSwap = true;
                    ++comparisons;
                }
            }
            ++i;
        }
        return comparisons;
    }

    private void swap(int[] a, int i, int j) {
        a[i] ^= a[j];
        a[j] = a[i] ^ a[j];
        a[i] ^= a[j];
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
