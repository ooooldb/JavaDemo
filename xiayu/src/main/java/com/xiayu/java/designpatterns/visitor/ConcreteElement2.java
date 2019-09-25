package com.xiayu.java.designpatterns.visitor;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class ConcreteElement2 extends Element {
    @Override
    public void doSomething() {

    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
