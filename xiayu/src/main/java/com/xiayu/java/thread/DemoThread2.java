package com.xiayu.java.thread;

/**
 * @author: starc
 * @date: 2018/12/17
 */
public class DemoThread2 implements Runnable {

    @Override
    public void run() {
        synchronized (DemoThread2.class) {
            System.out.println("今");
            System.out.println("天");
            System.out.println("是");
            System.out.println("十");
            System.out.println("二");
            System.out.println("月");
            System.out.println("十");
            System.out.println("七");
            System.out.println("号");
            System.out.println("！");
        }
    }
}
