package com.xiayu.java.designpatterns.state;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class Client {
    public static void main(String[] args) {
        Context context=new Context();
        context.setCurrentState(new ConcreteState1());
        context.handler1();
        context.handler2();
    }
}
