package com.xiayu.JavaDemo.xiayu.java.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author: starc
 * @date: 2019/3/16
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("------排序后");
        sort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1])
                System.out.println("无序");
        }
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int p, int r) {
        if (p < r) {
            int q = partition(a, p, r);
            sort(a, p, q - 1);
            sort(a, q + 1, r);
        }
    }

    private static int partition(int[] a, int p, int r) {
        int x = a[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (a[j] <= x) {
                i++;
                exchange(a, i, j);
            }
        }
        exchange(a, i + 1, r);
        return i + 1;
    }

    private static void exchange(int[] a, int x, int y) {
        int tem = a[x];
        a[x] = a[y];
        a[y] = tem;
    }
}
