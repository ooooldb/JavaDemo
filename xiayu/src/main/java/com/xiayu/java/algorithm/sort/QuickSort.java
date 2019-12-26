package com.xiayu.java.algorithm.sort;

/**
 * @author: test_
 * @date: 2019/10/22
 */
public class QuickSort {

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }

    private static int partition(int[] arr, int l, int h) {
        int index = l;
        for (int i = l; i < h; i++) {
            if (arr[i] < arr[h]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, index, h);
        return index;
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
