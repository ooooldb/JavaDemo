package com.xiayu.JavaDemo.xiayu.java.java.algorithms.sort;

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
        int[] arr = new int[99999999];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        long first = System.currentTimeMillis();
        ChoiceSort.sort(arr);
        long now = System.currentTimeMillis() - first;
        System.out.println("耗时:" + now / 1000 + "秒");
        if (checkSort(arr)) {
            System.out.println("数组有序");
        } else {
            System.out.println("数组无序");
        }
    }
}
