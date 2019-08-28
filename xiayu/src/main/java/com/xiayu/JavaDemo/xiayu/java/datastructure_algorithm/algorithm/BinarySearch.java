package com.xiayu.JavaDemo.xiayu.java.datastructure_algorithm.algorithm;

/**
 * @author: starc
 * @date: 2019/7/20
 */
public class BinarySearch {
    /*
        1. high=arr.length 错误 high应为arr.length-1;索引可达的最大值
        2. while (index < low || index > high) 直接不循环跳出
     */
    public static int rank(int key, int[] arr) {
        int high = arr.length-1;
        int low = 0;
        int index = (low + high) / 2;
        while (low<=high) {
            int mid = low+(high-low)/2;
            if (arr[index] == key)
                return index;
            else if (arr[index] > key) {
                high = index - 1;
            } else {
                low = index + 1;
            }
            index = (high + low) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {12,14,18,24,28,34};
        int rank = rank(12, arr);
        System.out.println(rank);
    }
}
