package com.xiayu.java.designpatterns.strategy;


/**
 * @author: starc
 * @date: 2019/1/22
 */
public class Context {
    /**
     * 抽象策略
     */
    private Strategy strategy;

    /**
     * 构造函数设置具体策略
     *
     * @param strategy
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 封装后的策略方法
     */
    public void doAnything() {
        this.strategy.doSomething();
    }
}
