package com.xiayu.java.designpatterns.visitor;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public interface IVisitor {
    void visit(ConcreteElement1 element1);
    void visit(ConcreteElement2 element2);
}
