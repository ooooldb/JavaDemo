package com.xiayu.JavaDemo.xiayu.java.coll;

import org.junit.Test;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author: starc
 * @date: 2018/12/22
 */
public class MyIterator implements Iterator{
    @Override
    public boolean hasNext() {
        System.out.println("hasNext");
        return false;
    }

    @Override
    public Object next() {
        System.out.println("hello next");
        return null;
    }

    @Override
    public void remove() {
        System.out.println("hello remove");
    }

    @Override
    public void forEachRemaining(Consumer action) {
        System.out.println("hello forEachRemaining");
    }
    @Test
    public void test() {

    }

}
