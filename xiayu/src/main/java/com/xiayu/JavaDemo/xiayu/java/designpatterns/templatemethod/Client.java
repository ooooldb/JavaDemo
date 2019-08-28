package com.xiayu.JavaDemo.xiayu.java.designpatterns.templatemethod;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class Client {
    public static void main(String[] args) {
        AbstractClass class1 = new ConcreteClass1();
        AbstractClass class2 = new ConcreteClass2();
        class1.templateMethod();
        class2.templateMethod();
    }
}
