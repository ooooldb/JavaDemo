package com.xiayu.JavaDemo.xiayu.java.designpatterns.strategy;

/**
 * @author: starc
 * @date: 2019/1/22
 */
public class ConcreteStrategy2 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略2的运算法则");
    }
}
