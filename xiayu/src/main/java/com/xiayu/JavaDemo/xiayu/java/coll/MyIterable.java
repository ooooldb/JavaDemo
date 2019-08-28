package com.xiayu.JavaDemo.xiayu.java.coll;

import org.junit.Test;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author: starc
 * @date: 2018/12/22
 */
public class MyIterable implements Iterable {

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
    @Test
    public void test() {
        MyIterator myItrator = new MyIterator();

    }

}
