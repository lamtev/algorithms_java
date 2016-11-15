package com.lamtev.eolymp;

import java.io.*;
import java.util.Scanner;

public class MegaGCD {

    private Scanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new MegaGCD().run();
    }

    public void run() {
        try {
            in = new Scanner(System.in);
            out = new PrintWriter(System.out);

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void solve() throws IOException {
        int res = in.nextInt();
        while (in.hasNext()) {
            res = gcd(res, in.nextInt());
        }
        out.println(res);
    }

    private int gcd(int first, int second) {
        while (first != 0 && second != 0) {
            if (first >= second) {
                first %= second;
            } else {
                second %= first;
            }
        }
        return first | second;
    }

}
