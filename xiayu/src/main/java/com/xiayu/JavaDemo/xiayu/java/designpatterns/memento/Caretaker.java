package com.xiayu.JavaDemo.xiayu.java.designpatterns.memento;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
