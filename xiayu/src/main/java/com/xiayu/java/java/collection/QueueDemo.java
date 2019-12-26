package com.xiayu.java.java.collection;

import java.util.AbstractQueue;
import java.util.Iterator;

/**
 * @author: test_
 * @date: 2019/11/26
 */
public class QueueDemo extends AbstractQueue {
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean offer(Object o) {
        return false;
    }

    @Override
    public Object poll() {
        return null;
    }

    @Override
    public Object peek() {
        return null;
    }
}
