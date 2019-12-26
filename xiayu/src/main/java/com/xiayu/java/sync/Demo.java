package com.xiayu.java.sync;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: starc
 * @date: 2018/12/20
 */
public class Demo {
    public volatile static int a = 0;
    private Lock lock = new ReentrantLock();

    @Test
    public void test() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                for (int i = 0; i < 5000; i++) {
                    a++;
                }
                lock.unlock();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                for (int i = 0; i < 5000; i++) {
                    a++;
                }
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);
        System.out.println(a);
    }

    /**
     * 两个线程交替执行的例子
     * @throws InterruptedException
     */
    @Test
    public void test1() throws InterruptedException {
        //锁对象
        Object o = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    //这条线程输出0-100的偶数
                    for (int j = 0; j <= 100; j=j+2) {
                        System.out.println(Thread.currentThread().getName()+" "+j);
                        try {
                            //唤醒线程，然后自己进入等待
                            o.notify();
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    //这条线程输出0-100的奇数
                    for (int j = 1; j <= 100; j=j+2) {
                        System.out.println(Thread.currentThread().getName()+" "+j);
                        try {
                            //唤醒另一条线程，自己进入等待状态
                            o.notify();
                            o.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t1.start();
        t2.start();
        Thread.sleep(1000);
    }
    /**
     * 测试notify
     * @throws InterruptedException
     */
    @Test
    public void test2() throws InterruptedException {
        //锁对象
        Object o = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    for (int j = 0; j <= 10000; j=j+2) {
                        System.out.println(Thread.currentThread().getName()+" "+j);
                        o.notify();
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o) {
                    //这条线程输出0-100的奇数
                    for (int j = 1; j <= 100; j=j+2) {
                        System.out.println(Thread.currentThread().getName()+" "+j);
                    }
                }
            }
        });
        t2.start();
        t1.start();
        Thread.sleep(1000);
    }
}
