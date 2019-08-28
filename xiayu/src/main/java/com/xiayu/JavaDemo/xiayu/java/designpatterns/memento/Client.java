package com.xiayu.JavaDemo.xiayu.java.designpatterns.memento;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class Client {
    public static void main(String[] args) {
        Originator originator=new Originator();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        originator.restoreMemento(caretaker.getMemento());
    }
}
