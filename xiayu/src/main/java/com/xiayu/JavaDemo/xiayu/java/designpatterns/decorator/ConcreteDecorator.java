package com.xiayu.JavaDemo.xiayu.java.designpatterns.decorator;

/**
 * @author: starc
 * @date: 2019/1/27
 */
public class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(Component _component) {
        super(_component);
    }

    @Override
    public void methodA() {
        System.out.println("before");
        this.component.methodA();
        System.out.println("after");
    }
}
