package com.xiayu.java.java.oop;

/**
 * @author: starc
 * @date: 2019/2/13
 */
public class Demo {
    //Java使用访问修饰符来实现封装
    //只有Demo类内部可以访问
    private int privateInt;
    //所在包的类可以访问
    int defaultInt;
    //所在包+继承该类的类可以访问
    protected int protectedInt=10;
    //所有类均可访问
    public int publicInt;
    final void fuck(){
        System.out.println("fuck");
    }
}
