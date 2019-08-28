package com.xiayu.JavaDemo.xiayu.java.designpatterns.observer;

import java.util.Vector;

/**
 * @author: starc
 * @date: 2019/1/26
 */
public class ConcreteSubject implements Subject {

    private Vector<Observer> observers=new Vector<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer o:
             observers) {
            o.update();
        }
    }
}
