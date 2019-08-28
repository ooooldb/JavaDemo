package com.xiayu.JavaDemo.xiayu.java.designpatterns.Iterator;

import java.util.Vector;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class ConcreteAggregate implements Aggregate {
    private Vector vector = new Vector();

    @Override
    public void add(Object object) {
        vector.add(object);
    }

    @Override
    public void remove(Object object) {
        remove(object);
    }

    @Override
    public Iterator iterator() {
        return new ConcreteIterator(this.vector);
    }
}
