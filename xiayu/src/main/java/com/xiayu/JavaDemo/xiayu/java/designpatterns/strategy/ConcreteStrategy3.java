package com.xiayu.JavaDemo.xiayu.java.designpatterns.strategy;

/**
 * @author: starc
 * @date: 2019/1/22
 */
public class ConcreteStrategy3 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略3的运算法则");
    }
}
