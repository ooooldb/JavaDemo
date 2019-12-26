package com.xiayu.java.designpatterns.bridge;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class Client {
    public static void main(String[] args) {
        Implementor imp=new ConcreteImplementor1();
        Abstraction abs=new RefinedAbstraction(imp);
        abs.request();
    }
}
