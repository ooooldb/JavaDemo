package com.xiayu.JavaDemo.xiayu.java.designpatterns.mediator;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator _mediator) {
        this.mediator = _mediator;
    }
}
