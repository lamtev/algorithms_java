package com.lamtev.eolymp;

import java.io.*;
import java.util.Scanner;

public class SimpleQueue {

    private Scanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new SimpleQueue().run();
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
        try {
            CutSimpleQueue queue = new CutSimpleQueue();
            while (true) {
                String command = in.nextLine();
                switch (command) {
                    case "extract":
                        out.println(queue.pop());
                        break;
                    case "front":
                        out.println(queue.front());
                        break;
                    case "size":
                        out.println(queue.size());
                        break;
                    case "clear":
                        queue.clear();
                        out.println("ok");
                        break;
                    case "exit":
                        out.println("bye");
                        return;
                    default:
                        queue.push(Integer.parseInt(command.substring(5)));
                        out.println("ok");
                }
            }

        } catch (RuntimeException e) {
            out.println("ok");
        }
    }

    private class CutSimpleQueue {

        private int[] buffer = new int[100];
        private int size = 0;
        private int head = 0;
        private int tail = -1;

        public void push(int n) {
            if (tail == 99) {
                int[] newBuffer = new int[100];
                int j = 0;
                for (int i = head; i <= tail; ++i) {
                    newBuffer[j++] = buffer[i];
                }
                buffer = newBuffer;
                tail -= head;
                head = 0;

            }
            ++size;
            buffer[++tail] = n;
        }

        public int pop() {
            --size;
            int old = buffer[head++];
            if (size == 0) {
                head = 0;
                tail = -1;
            }
            return old;
        }

        public int front() {
            return buffer[head];
        }

        public int size() {
            return size;
        }

        public void clear() {
            for (int i = 0; i < buffer.length; ++i) {
                buffer[i] = 0;
            }
            size = 0;
            head = 0;
            tail = -1;
        }

    }
}
