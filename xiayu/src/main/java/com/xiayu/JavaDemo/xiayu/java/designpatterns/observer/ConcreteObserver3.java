package com.xiayu.JavaDemo.xiayu.java.designpatterns.observer;

/**
 * @author: starc
 * @date: 2019/1/26
 */
public class ConcreteObserver3 implements Observer {

    private Subject subject;

    public ConcreteObserver3(Subject subject) {
        this.subject = subject;
    }

    public Subject getSubject() {
        return subject;
    }

    @Override
    public void update() {
        System.out.println("ConcreteObserver2收到通知");
    }
}
