package com.xiayu.java.java.base;

import java.util.Arrays;

/**
 * @author: test_
 * @date: 2019/11/27
 */
public class regularExpressionDemo {
    public static void main(String[] args) {
        String string = "1231231";
        String[] split = string.split("[0-9]*");
        System.out.println(Arrays.toString(split));
    }
}
