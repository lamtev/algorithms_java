package com.lamtev.eolymp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AntiQuicksort {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new AntiQuicksort().run();
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
            a[i] = i + 1;
        }
        for (int i = 2; i < n; ++i) {
            swap(a, i, (i >> 1));
        }
        for (int x : a) {
            out.print(x + " ");
        }
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