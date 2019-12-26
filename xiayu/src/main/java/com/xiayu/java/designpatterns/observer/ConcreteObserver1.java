package com.xiayu.java.designpatterns.observer;

/**
 * @author: starc
 * @date: 2019/1/26
 */
public class ConcreteObserver1 implements Observer {

    private Subject subject;

    public ConcreteObserver1(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public void update() {
        System.out.println("ConcreteObserver1收到通知");
    }
}
