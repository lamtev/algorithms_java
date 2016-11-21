package com.lamtev.eolymp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MethodOfMinimum {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new MethodOfMinimum().run();
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
        out.println(sort(a));
    }

    private int sort(int[] a) {
        int displacementsOfFirst = 0;
        int n = a.length;
        int iFirst = 0;
        for (int left = 0; left < n; ++left) {
            int iMin = iMin(a, left, n - 1);
            swap(a, left, iMin);
            if (left != iMin && iFirst == left) {
                iFirst = iMin;
                ++displacementsOfFirst;
            } else if (left != iMin && iFirst == iMin) {
                iFirst = left;
                ++displacementsOfFirst;
            }

        }
        return displacementsOfFirst;
    }

    private int iMin(int[] a, int left, int right) {
        int iMin = left;
        for (int i = left + 1; i <= right; ++i) {
            if (a[i] < a[iMin]) {
                iMin = i;
            }
        }
        return iMin;
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
