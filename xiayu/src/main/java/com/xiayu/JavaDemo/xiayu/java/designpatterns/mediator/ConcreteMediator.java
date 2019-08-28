package com.xiayu.JavaDemo.xiayu.java.designpatterns.mediator;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class ConcreteMediator extends Mediator {
    @Override
    public void doSomething1() {
        c1.selfMethod1();
        c2.selfMethod2();
    }

    @Override
    public void doSomething2() {
        c1.selfMethod2();
        c2.selfMethod1();
    }
}
