package com.lamtev.algorithms_java.lab1;

import java.io.*;
import java.util.StringTokenizer;

public class IsHeap {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new IsHeap().run();
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
        try {
            int n = in.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) {
                array[i] = in.nextInt();
            }
            out.println(isHeap(array) ? "YES" : "NO");
        } catch (Exception e) {
            out.println("NO");
        }
    }

    private boolean isHeap(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; ++i) {
            if (!((!(2*i+1 < n)|| array[i] <= array[2*i+1]) && (!(2*i+2 < n) || array[i] <= array[2*i+2]))) {
                return false;
            }
        }
        return true;
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
