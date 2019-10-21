package com.xiayu.java;

import java.util.Random;

/**
 * @author: test_
 * @date: 2019/10/18
 */
public class Study {
    private static int studyNumber(int maxNum) {
        Random random = new Random();
        return random.nextInt(maxNum) + 1;
    }

    public static void main(String[] args) {
        System.out.println(studyNumber(6));
    }
}
