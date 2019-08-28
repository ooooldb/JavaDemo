package com.xiayu.JavaDemo.xiayu.java.designpatterns.adapter;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class Adapter extends Adaptee implements Target {
    @Override
    public void request() {
        super.doSomething();
    }
}
