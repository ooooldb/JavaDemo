package com.xiayu.java.designpatterns.adapter;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("if you need any help,pls call me");
    }
}
