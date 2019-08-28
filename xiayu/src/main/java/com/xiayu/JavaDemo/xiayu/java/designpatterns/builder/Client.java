package com.xiayu.JavaDemo.xiayu.java.designpatterns.builder;

/**
 * @author: starc
 * @date: 2019/1/31
 */
public class Client {
    public static void main(String[] args) {
        Director director = new Director();
        Product product = director.getProduct();
    }
}
