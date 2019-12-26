package com.xiayu.java.algorithm.sort;

/**
 * @author: test_
 * @date: 2019/10/23
 */
public class CountSort {

    public static void sort(int[] arr) {
        bucketSort(arr);
    }

    private static void bucketSort(int[] arr) {
        if (arr.length < 1) {
            return;
        }
        int min = arr[0];
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
            if (value < min) {
                min = value;
            }
        }
        int[] bucket = new int[max - min + 1];
        for (int value : arr) {
            bucket[value - min]++;
        }
        int index = 0;
        for (int j = 0; j < bucket.length; j++) {
            int length = bucket[j];
            for (int i = 0; i < length; i++) {
                arr[index++] = j + min;
            }
        }

    }

    private class CountingSort {

        public void sort(int[] sourceArray) {
            int maxValue = getMaxValue(sourceArray);
            countingSort(sourceArray, maxValue);
        }

        private void countingSort(int[] arr, int maxValue) {
            int bucketLen = maxValue + 1;
            int[] bucket = new int[bucketLen];

            for (int value : arr) {
                bucket[value]++;
            }

            int sortedIndex = 0;
            for (int j = 0; j < bucketLen; j++) {
                while (bucket[j] > 0) {
                    arr[sortedIndex++] = j;
                    bucket[j]--;
                }
            }
        }

        private int getMaxValue(int[] arr) {
            int maxValue = arr[0];
            for (int value : arr) {
                if (maxValue < value) {
                    maxValue = value;
                }
            }
            return maxValue;
        }

    }

    private class Counting_Sort {

    }
}
