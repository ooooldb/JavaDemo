package com.xiayu.java.algorithm.sort;

/**
 * @author: test_
 * @date: 2019/10/21
 */
public class HeapSort {
    private static int heapSize;

    public static void maxHeapify(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left <= heapSize && arr[left] > arr[i]) {
            largest = left;
        }
        if (right <= heapSize && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            exchange(arr, largest, i);
            maxHeapify(arr, largest);
        }
    }

    private static void exchange(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void buildMaxHeap(int[] arr) {
        heapSize = arr.length - 1;
        int size = (heapSize-1) / 2;
        for (int i = size; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    public static void sort(int[] arr) {
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i >= 1; i--) {
            exchange(arr, 0, i);
            heapSize--;
            maxHeapify(arr, 0);
        }
    }
}
