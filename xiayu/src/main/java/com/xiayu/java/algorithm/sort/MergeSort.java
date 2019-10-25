package com.xiayu.java.algorithm.sort;

/**
 * @author: starc
 * @date: 2019/10/21
 */
public class MergeSort {

    public static void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /*
        自顶向下
     */
    private static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (int) Math.floor((start + end) / 2);
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    /*
        自底向上
     */
    public static void mergeSort(int[] arr) {
        int n = arr.length;
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(arr, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        System.arraycopy(arr, start, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[start + i + j] = left[i];
                i++;
            } else {
                arr[start + i + j] = right[j];
                j++;
            }
        }
        if (i < n1) {
            System.arraycopy(left, i, arr, start + i + j, n1 - i);
        } else {
            System.arraycopy(right, j, arr, start + i + j, n2 - j);
        }
    }
}
