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
        int expectedNumberOfHouses = in.nextInt();
        int[] ropesLengths = new int[10001];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        boolean willClose = true;
        for (int i = 0; i < numberOfRopes; ++i) {
            ropesLengths[i] = in.nextInt();
            if (ropesLengths[i] > max) {
                max = ropesLengths[i];
            }
            if (willClose) {
                sum += ropesLengths[i];
                if (sum >= expectedNumberOfHouses) {
                    willClose = false;
                }
            }
        }
        if (willClose) {
            out.println(0);
            return;
        }
        int left = 0;
        int right = max;
        while (left < right-1) {
            int mid = (left + right) / 2;
            int actualNumberOfHouses = 0;
            for (int ropeLength : ropesLengths) {
                actualNumberOfHouses += ropeLength/mid;
            }
            if (actualNumberOfHouses < expectedNumberOfHouses) {
                right = mid;
            } else {
                left = mid;
            }
        }
        out.println(left);
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
