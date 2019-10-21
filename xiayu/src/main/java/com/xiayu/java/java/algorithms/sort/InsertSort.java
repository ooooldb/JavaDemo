package com.xiayu.java.java.algorithms.sort;

/**
 * @author: test_
 * @date: 2019/9/17
 */
public class InsertSort {
    /*
        插入排序
     */
    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];
            int j;
            for (j = i; j > 0 && now < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = now;
        }
    }
}
