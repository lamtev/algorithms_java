package com.lamtev.algorithms_java.lab1;

import java.io.*;
import java.util.StringTokenizer;

public class Ropes {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new Ropes().run();
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
        int numberOfRopes = in.nextInt();
        int numberOfHouses = in.nextInt();
        int[] ropesLengths = new int[numberOfRopes];
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < numberOfRopes; ++i) {
            ropesLengths[i] = in.nextInt();
            if (ropesLengths[i] < min) {
                min = ropesLengths[i];
            }
            sum += ropesLengths[i];
        }
        if (sum < numberOfHouses) {
            out.println(0);
            return;
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
