package com.xiayu.JavaDemo.xiayu.java.designpatterns.Iterator;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public interface Aggregate {
    void add(Object object);
    void remove(Object object);
    Iterator iterator();
}
