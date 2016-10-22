package com.lamtev.algorithms_java.lab1;

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
        //tests crash when i use byte and short
        int numberOfTests = in.nextInt();
        int a = 0;
        for (int i = 0; i < numberOfTests << 1; ++i) {
            if (i % 2 == 0) {
                a = in.nextInt();
            } else {
                out.println(a + in.nextInt());
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

        byte nextByte() {
            return Byte.parseByte(next());
        }

        short nextShort() {
            return Short.parseShort(next());
        }

    }

}
