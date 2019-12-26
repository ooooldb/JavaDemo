package com.xiayu.java.java.oop;

/**
 * @author: starc
 * @date: 2019/2/13
 */
public class Demo2 extends Demo{
    public Demo2(){
        fuck();
    }
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.protectedInt=20;
        System.out.println();
        demo2.print();
        String str = "hello";
        str =str+"world";
        System.out.println(str);
    }
    public void print(){
        System.out.println(super.protectedInt);
    }


}
