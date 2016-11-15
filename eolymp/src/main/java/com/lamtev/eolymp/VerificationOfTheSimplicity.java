package com.lamtev.eolymp;

import java.io.*;
import java.util.StringTokenizer;

public class VerificationOfTheSimplicity {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new VerificationOfTheSimplicity().run();
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
        out.println(isPrime(in.nextInt()) ? "True" : "False");
    }

    private boolean isPrime(long number) {
        if (number <= 1)
            return false;
        for (int i = 2; i*i <= number; ++i)
            if (number % i == 0)
                return false;
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
