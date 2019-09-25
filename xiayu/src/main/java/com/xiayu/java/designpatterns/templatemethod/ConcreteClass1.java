package com.xiayu.java.designpatterns.templatemethod;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class ConcreteClass1 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("ConcreteClass1 do something");
    }

    @Override
    protected void doAnything() {
        System.out.println("ConcreteClass1 do anything");
    }
}
