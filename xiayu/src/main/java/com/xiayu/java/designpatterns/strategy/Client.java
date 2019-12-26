package com.xiayu.java.designpatterns.strategy;

/**
 * @author: starc
 * @date: 2019/1/22
 */
public class Client {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategy1();
        Context context = new Context(strategy);
        context.doAnything();
    }
}
