package com.lamtev.eolymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class HeapSort {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(new File("input.txt"))) {
            PrintWriter out = new PrintWriter("output.txt");
            String[] s = in.nextLine().split(" ");
            int n = s.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(s[i]);
            }
            sort(a);
            for (int i : a) {
                out.print(i + " ");
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void sort(int[] a) {
        Heap heap = new Heap();
        for (int x : a) {
            heap.insert(x);
        }
        for (int i = a.length - 1; i >= 0; --i) {
            a[i] = heap.extract();
        }
    }

    private static class Heap {

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
                        i <<= 1;
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
            heap[i] ^= heap[j];
            heap[j] = heap[i] ^ heap[j];
            heap[i] ^= heap[j];
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

}
