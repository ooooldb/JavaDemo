package com.xiayu.java.util;

import java.util.Random;

/**
 * @author: test_
 * @date: 2019/9/26
 */
public class RandomNumberUtil {
    private static Random random = new Random();

    public static int getRandomNumber(int max) {
        return random.nextInt(max) + 1;
    }

    public static void main(String[] args) {
        //今天学啥
        System.out.println(getRandomNumber(5));
    }
}
