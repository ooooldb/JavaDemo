package com.xiayu.java.designpatterns.bridge;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class RefinedAbstraction extends Abstraction {
    public RefinedAbstraction(Implementor imp) {
        super(imp);
    }

    @Override
    public void request() {
        super.request();
        super.getImp().doAnything();
    }
}
