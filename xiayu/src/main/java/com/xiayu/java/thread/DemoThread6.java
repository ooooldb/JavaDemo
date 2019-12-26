package com.xiayu.java.thread;

/**
 * 守护线程测试
 * @author: starc
 * @date: 2018/12/17
 */
public class DemoThread6 {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        });
        t1.setDaemon(true);
        t1.start();
        t2.start();
    }
}
