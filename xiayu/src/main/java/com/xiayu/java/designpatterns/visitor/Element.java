package com.xiayu.java.designpatterns.visitor;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public abstract class Element {
    public abstract void doSomething();
    public abstract void accept(IVisitor visitor);
}
