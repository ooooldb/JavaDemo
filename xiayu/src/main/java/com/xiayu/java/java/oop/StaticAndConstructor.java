package com.xiayu.java.java.oop;

/**
 * @author: starc
 * @date: 2019/7/4
 */
public class StaticAndConstructor {
    public static void main(String[] args) {
        new Son();
    }
}

class Son extends Father {
    public Son() {
        System.out.println("son constructor");
    }

    {
        System.out.println("son code block");
    }

    static {
        System.out.println("son static");
    }
}

class Father {
    public Father() {
        System.out.println("Father constructor");
    }

    {
        System.out.println("Father code block");
    }

    static {
        System.out.println("Father static");
    }
}