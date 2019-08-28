package com.xiayu.JavaDemo.xiayu.java.designpatterns.decorator;

/**
 * @author: starc
 * @date: 2019/1/27
 */
public abstract class Decorator implements Component {
    protected Component component;

    public Decorator(Component _component) {
        this.component=_component;
    }

    @Override
    public void methodA() {
        this.component.methodA();
    }
}
