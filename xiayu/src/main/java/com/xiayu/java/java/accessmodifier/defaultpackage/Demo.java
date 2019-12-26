package com.xiayu.java.java.accessmodifier.defaultpackage;

/**
 * @author: starc
 * @date: 2019/2/11
 */
public class Demo {
    //成员变量
    int anInt = 10;
    Demo demo = new Demo();
    static int anInt1;

    enum Size {SMALL, MEDIUM, LARGE}

    ;
    //方法


    public static int sum(int a, int b) {
        return a + b;
    }

    public static double sum(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        String str = "hello" + " " + "world!";
        System.out.println(str);
        System.out.println();
    }
}
