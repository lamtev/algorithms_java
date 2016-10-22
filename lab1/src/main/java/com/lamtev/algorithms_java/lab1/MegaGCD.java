package com.lamtev.algorithms_java.lab1;

import java.io.*;
import java.util.StringTokenizer;

public class MegaGCD {

    private FastScanner in;
    private PrintWriter out;
    private int[] numberDividers;
    private int[] commonDividers;

    public static void main(String[] args) {
        new MegaGCD().run();
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
        while (in.hasNext()) {
            int number = in.nextInt();

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

        boolean hasNext() {
            return st == null || !st.hasMoreTokens();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }

}
