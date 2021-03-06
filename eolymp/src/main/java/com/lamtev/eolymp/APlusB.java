package com.lamtev.eolymp;

import java.io.*;
import java.util.StringTokenizer;

public class APlusB {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new APlusB().run();
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
        //tests crash when i want to optimize using byte and short :(
        int numberOfTests = in.nextInt();
        int count = 0;
        while (count < numberOfTests) {
            out.println(in.nextInt() + in.nextInt());
            ++count;
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
