package com.xiayu.java.designpatterns.factorymethod.simplefactory;

/**
 * @author: starc
 * @date: 2019/1/30
 */
public class Factory {
    private Factory(){}

    public static ConcreteProduct1 createProduct1(){
        return new ConcreteProduct1();
    }

    public static ConcreteProduct2 createProduct2(){
        return new ConcreteProduct2();
    }

}
