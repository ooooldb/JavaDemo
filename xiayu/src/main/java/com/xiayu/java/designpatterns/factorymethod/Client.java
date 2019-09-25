package com.xiayu.java.designpatterns.factorymethod;

/**
 * @author: starc
 * @date: 2019/1/30
 */
public class Client {
    public static void main(String[] args) {
        Creator creator = new ConcreteCreator();
        Product product=creator.createProduct(ConcreteProduct1.class);
        //业务处理
    }
}
