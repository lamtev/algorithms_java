package com.lamtev.eolymp;

import java.io.*;
import java.util.StringTokenizer;

public class Revision {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new Revision().run();
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
        int smallest = Integer.MAX_VALUE;
        int almostSmallest = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            int current = in.nextInt();
            if (current < smallest) {
                almostSmallest = smallest;
                smallest = current;
            } else if (current < almostSmallest) {
                almostSmallest = current;
            }
        }
        out.println(smallest + " " + almostSmallest);
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
