package com.lamtev.eolymp;

import java.io.*;
import java.util.StringTokenizer;

public class LibraryMethod {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new LibraryMethod().run();
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
        sort(a);
    }

    private void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; ++i) {
            boolean wasInsertion = false;
            for (int j = i; j > 0 && a[j] < a[j-1]; --j) {
                swap(a, j, j-1);
                wasInsertion = true;
            }
            if (wasInsertion) {
                print(a);
            }
        }
    }

    private void print(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; ++i) {
            out.print(a[i]);
            if (i != n - 1) {
                out.print(" ");
            }
        }
        out.println();
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
