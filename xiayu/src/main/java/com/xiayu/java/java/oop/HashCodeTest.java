package com.xiayu.java.java.oop;

/**
 * @author: starc
 * @date: 2019/3/16
 */
public class HashCodeTest {
    public static void main(String[] args) {
        String str = "ok";
        String str2 = "ok";
        String str1 = new String("ok");
        System.out.println(str.hashCode());
        System.out.println(str1.hashCode());
        System.out.println(str==str1);
        System.out.println(str2==str);
    }
}
