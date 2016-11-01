package com.lamtev.algorithms_java.lab1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GoHeap {

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) {
        new GoHeap().run();
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
        Heap heap = new Heap();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int command = in.nextInt();
            switch (command) {
                case 0:
                    heap.insert(in.nextInt());
                    break;
                default:
                    out.println(heap.extract());
                    break;
            }
        }
    }

    public static class Heap {

        private static final int DEFAULT_CAPACITY = 10;
        private int[] heap = new int[DEFAULT_CAPACITY];
        private int size = 1;

        public void insert(int value) {
            growUp();
            heap[size] = value;
            siftUp(size);
            size++;
        }

        public int extract() {
            int value = heap[1];
            heap[1] = heap[--size];
            siftDown(1);
            shrinkDown();
            return value;
        }

        private void siftUp(int i) {
            while (i > 1 && heap[i] > heap[(i >> 1)]) {
                swap(i, i >> 1);
                i >>= 1;
            }
        }

        private void siftDown(int i) {
            while (i << 1 <= size) {
                if ((i << 1) + 1 > size) {
                    if (heap[i] >= heap[(i << 1) + 1]) {
                        swap(i, i << 1);
                        i <<= 1;
                    }
                    break;
                }
                if (heap[i] < heap[(i << 1)]) {
                    if (heap[i] >= heap[(i << 1) + 1]) {
                        swap(i, i << 1);
                        i *= 2;
                    } else {
                        int max;
                        if (heap[(i << 1)] <= heap[(i << 1) + 1]) {
                            max = (i << 1) + 1;
                        } else {
                            max = i << 1;
                        }
                        swap(i, max);
                        i = max;
                    }
                } else if (heap[i] < heap[(i << 1) + 1]) {
                    swap(i, (i << 1) + 1);
                    i = (i << 1) + 1;
                } else {
                    break;
                }
            }
        }

        private void swap(int i, int j) {
            heap[i] = heap[i] ^ heap[j];
            heap[j] = heap[i] ^ heap[j];
            heap[i] = heap[i] ^ heap[j];
        }

        private void growUp() {
            if (size == heap.length) {
                heap = Arrays.copyOf(heap, heap.length << 1);
            }
        }

        private void shrinkDown() {
            if (size > DEFAULT_CAPACITY && size >= heap.length << 2) {
                heap = Arrays.copyOf(heap, heap.length >> 1);
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