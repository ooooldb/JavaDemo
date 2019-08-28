package com.xiayu.JavaDemo.xiayu.java.designpatterns.mediator;

/**
 * ### 中介者模式
 * 用一个中介对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，
 * 从而使其耦合松散，而且可以独立地改变它们之间的交互
 * @author: starc
 * @date: 2019/1/28
 */
public abstract class Mediator {
    protected ConcreteColleague1 c1;
    protected ConcreteColleague2 c2;

    public ConcreteColleague1 getC1() {
        return c1;
    }

    public void setC1(ConcreteColleague1 c1) {
        this.c1 = c1;
    }

    public ConcreteColleague2 getC2() {
        return c2;
    }

    public void setC2(ConcreteColleague2 c2) {
        this.c2 = c2;
    }

    public abstract void doSomething1();
    public abstract void doSomething2();
}
