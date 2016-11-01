package com.lamtev.algorithms_java.lab1;

import java.io.*;
import java.util.Scanner;

public class PostfixNotation {

    private Scanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new PostfixNotation().run();
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
        String[] tokens = in.nextLine().split("\\s+");
        int size = 0;
        int[] stack = new int[100];
        int first;
        int second;
        for (String token : tokens) {
            switch (token) {
                case "+" :
                    second = stack[--size];
                    first = stack[--size];
                    stack[size++] = first + second;
                    break;
                case "-" :
                    second = stack[--size];
                    first = stack[--size];
                    stack[size++] = first - second;
                    break;
                case "*" :
                    second = stack[--size];
                    first = stack[--size];
                    stack[size++] = first * second;
                    break;
                default:
                    stack[size++] = Integer.parseInt(token);
            }
        }
        out.println(stack[size-1]);
    }

}
