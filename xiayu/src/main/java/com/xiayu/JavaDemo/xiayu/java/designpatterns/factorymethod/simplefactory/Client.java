package com.xiayu.JavaDemo.xiayu.java.designpatterns.factorymethod.simplefactory;

/**
 * @author: starc
 * @date: 2019/1/30
 */
public class Client {
    public static void main(String[] args) {
        Product product1 = Factory.createProduct1();
        Product product2 = Factory.createProduct2();
    }
}
