package com.xiayu.java.designpatterns.state;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class ConcreteState2 extends State {
    @Override
    public void handler1() {
        context.setCurrentState(Context.STATE2);
        context.handler2();
    }

    @Override
    public void handler2() {

    }
}
