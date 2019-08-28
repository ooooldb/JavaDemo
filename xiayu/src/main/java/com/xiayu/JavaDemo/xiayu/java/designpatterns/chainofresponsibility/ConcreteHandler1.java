package com.xiayu.JavaDemo.xiayu.java.designpatterns.chainofresponsibility;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class ConcreteHandler1 extends Handler {
    @Override
    protected Level getHandlerLevel() {
        return null;
    }

    @Override
    protected Response echo(Request request) {
        return null;
    }
}
