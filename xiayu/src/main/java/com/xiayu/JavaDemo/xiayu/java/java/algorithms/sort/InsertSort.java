package com.xiayu.JavaDemo.xiayu.java.java.algorithms.sort;

import java.util.Random;

/**
 * @author: test_
 * @date: 2019/9/17
 */
public class InsertSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j < 0 || arr[i] > arr[j]; j--) {

            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int tmp = arr[first];
        arr[first] = arr[second];
        arr[second] = tmp;
    }
}
