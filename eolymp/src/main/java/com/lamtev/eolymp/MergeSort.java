package com.lamtev.eolymp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MergeSort {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new MergeSort().run();
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
        int[][] ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = in.nextInt();
            ab[i][1] = in.nextInt();
        }
        sort(ab);
        for (int i = 0; i < n; i++) {
            out.println(ab[i][0] + " " + ab[i][1]);
        }
    }

    private static int[][] sort(int[][] ab) {
        int[][] temp = new int[ab.length][2];
        sort(ab, temp, 0, ab.length - 1);
        return ab;
    }

    private static void sort(int[][] ab, int[][] t, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        sort(ab, t, l, mid);
        sort(ab, t, mid + 1, r);
        MergeSort.merge(ab, t, l, mid, r);
    }

    private static void merge(int[][] ab, int[][] t, int l, int mid, int r) {
        System.arraycopy(ab, l, t, l, r + 1 - l);
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                ab[k] = t[j++];
            } else if (j > r) {
                ab[k] = t[i++];
            } else if (t[i][0] <= t[j][0]) {
                ab[k] = t[i++];
            } else if (t[i][0] > t[j][0]) {
                ab[k] = t[j++];
            }
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

