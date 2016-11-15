package com.lamtev.eolymp;

import java.io.*;
import java.util.StringTokenizer;

public class Columns {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new Columns().run();
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
        int x = in.nextInt();
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                arr[i][j] = in.nextInt();
            }
        }
        for (int i = 0; i < n; ++i) {
            boolean hasX = false;
            for (int j = 0; j < n; ++j) {
                if (arr[j][i] == x) {
                    out.println("YES");
                    hasX = true;
                    break;
                }
            }
            if (!hasX) out.println("NO");
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
