package com.xiayu.JavaDemo.xiayu.java.java.juc;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: starc
 * @date: 2019/3/11
 */
public class AtomicBooleanDemo {
    private static AtomicBoolean flag = new AtomicBoolean();
    private static AtomicInteger num = new AtomicInteger();
    public static void main(String[] args) {
        flag.compareAndSet(false, true);
        System.out.println(flag.get());
    }
}
