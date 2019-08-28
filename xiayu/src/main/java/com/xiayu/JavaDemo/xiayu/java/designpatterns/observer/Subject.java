package com.xiayu.JavaDemo.xiayu.java.designpatterns.observer;

/**
 * @author: starc
 * @date: 2019/1/25
 */
public interface Subject {
    /**
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * 删除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
