package com.xiayu.java.designpatterns.visitor;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class Visitor implements IVisitor {
    @Override
    public void visit(ConcreteElement1 element1) {
        element1.doSomething();
    }

    @Override
    public void visit(ConcreteElement2 element2) {
        element2.doSomething();
    }
}
