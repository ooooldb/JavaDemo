package com.xiayu.JavaDemo.xiayu.java.designpatterns.visitor;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class ConcreteElement1 extends Element {
    @Override
    public void doSomething() {

    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
