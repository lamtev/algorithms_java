package com.lamtev.eolymp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    private static Random random = new Random(System.currentTimeMillis());

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
        shuffle(a);
        quicksort(a, 0, a.length - 1);
    }

    private static void quicksort(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int pivot = partition(a, p, r);
        quicksort(a, p, pivot);
        quicksort(a, pivot + 1, r);
    }

    private static int partition(int[] a, int l, int r) {
        int x = a[l + (r - l + 1) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (a[i] < x) i++;
            while (a[j] > x) j--;
            if (i <= j) swap(a, i++, j--);
        }
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void shuffle(int[] a) {
        for (int i = 0; i < a.length; i++) {
            swap(a, i, i + random.nextInt(a.length - i));
        }
    }

}