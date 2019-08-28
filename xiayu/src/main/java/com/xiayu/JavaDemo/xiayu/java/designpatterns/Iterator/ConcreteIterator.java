package com.xiayu.JavaDemo.xiayu.java.designpatterns.Iterator;

import java.util.Vector;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class ConcreteIterator implements Iterator {
    private Vector vector = new Vector();
    public int cursor = 0;

    public ConcreteIterator(Vector _vector) {
        this.vector = vector;
    }

    @Override
    public Object next() {
        Object result = null;
        if(hasNext()){
            result=vector.get(cursor++);
        }else {
            result=null;
        }
        return result;
    }

    @Override
    public boolean hasNext() {
        return cursor != vector.size();
    }

    @Override
    public boolean remove() {
        vector.remove(cursor);
        return true;
    }
}
