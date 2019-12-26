package com.xiayu.java.designpatterns.bridge;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public abstract class Abstraction {
    private Implementor imp;

    public Abstraction(Implementor imp) {
        this.imp = imp;
    }

    public Implementor getImp() {
        return imp;
    }

    public void request(){
        imp.doSomething();

    }
}
