package com.xiayu.java.java.algorithms.sort;

/**
 * @author: test_
 * @date: 2019/10/21
 */
public class ShellSort {
    /*
        希尔排序
            基于插入排序的快速的排序算法
     */
    public static void sort(int[] arr) {
        int length = arr.length;
        int h = 1;
        while (h < length / 3)
            h = 3 * h + 1;
        for (; h >= 1; h = h / 3) {
            for (int i = h; i < length; i++) {
                int now = arr[i];
                int j;
                for (j = i; j >= h && now < arr[j - h]; j = j - h) {
                    arr[j] = arr[j - h];
                }
                arr[j] = now;
            }
        }
    }
}
