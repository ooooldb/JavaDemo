package com.xiayu.java.java.algorithms.sort;

import com.xiayu.java.leetcode.easy.Solution;
import org.junit.Test;

import java.util.Random;

/**
 * @author: test_
 * @date: 2019/9/24
 */
public class SortTest {

    public static boolean checkSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void choiceSortTest() {
        int[] arr = getRandomArr(9999);
        long first = System.currentTimeMillis();
        ChoiceSort.sort(arr);
        long now = System.currentTimeMillis() - first;
        System.out.println("耗时:" + now + "ms");
        if (checkSort(arr)) {
            System.out.println("数组有序");
        } else {
            System.out.println("数组无序");
        }
    }

    @Test
    public void insertSortTest() {
        int[] arr = getRandomArr(999999);
        long first = System.currentTimeMillis();
        InsertSort.sort(arr);
        long now = System.currentTimeMillis() - first;
        System.out.println("耗时:" + now + "ms");
        if (checkSort(arr)) {
            System.out.println("数组有序");
        } else {
            System.out.println("数组无序");
        }
    }

    @Test
    public void bubbleSortTest() {
        int[] arr = getRandomArr(9999);
        long first = System.currentTimeMillis();
        BubbleSort.sort(arr);
        long now = System.currentTimeMillis() - first;
        System.out.println("耗时:" + now + "ms");
        if (checkSort(arr)) {
            System.out.println("数组有序");
        } else {
            System.out.println("数组无序");
        }
    }

    @Test
    public void shellSortTest() {
        int[] arr = getRandomArr(999999);
        long first = System.currentTimeMillis();
        ShellSort.sort(arr);
        long now = System.currentTimeMillis() - first;
        System.out.println("耗时:" + now + "ms");
        if (checkSort(arr)) {
            System.out.println("数组有序");
        } else {
            System.out.println("数组无序");
        }
    }

    @Test
    public void mergeSortTest() {
        int[] arr = getRandomArr(999999);
        long first = System.currentTimeMillis();
        MergeSort.sort(arr);
        long now = System.currentTimeMillis() - first;
        System.out.println("耗时:" + now + "ms");
        if (checkSort(arr)) {
            System.out.println("数组有序");
        } else {
            System.out.println("数组无序");
        }
    }

    @Test
    public void mergeSortTest2() {
        int[] arr = getRandomArr(999999);
        long first = System.currentTimeMillis();
        MergeSort.mergeSort(arr);
        long now = System.currentTimeMillis() - first;
        System.out.println("耗时:" + now + "ms");
        if (checkSort(arr)) {
            System.out.println("数组有序");
        } else {
            System.out.println("数组无序");
        }
    }

    @Test
    public void heapSortTest() {
        int[] arr = getRandomArr(999999);
        long first = System.currentTimeMillis();
        HeapSort.sort(arr);
        long now = System.currentTimeMillis() - first;
        System.out.println("耗时:" + now + "ms");
        if (checkSort(arr)) {
            System.out.println("数组有序");
        } else {
            System.out.println("数组无序");
        }
    }

    @Test
    public void test27() {
        int[] arr = {3,2,2,3};
        Solution.removeElement(arr, 3);
        System.out.println("a");
    }

    private int[] getRandomArr(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(99999);
        }
        return arr;
    }
}
