package com.xiayu.java.thread;

/**
 * @author: starc
 * @date: 2018/12/17
 */
public class DemoThread5 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new DemoThread5());
        thread.setName("fuck");
        thread.start();
        for (int i = 0; i < 1000; i++) {
            //System.out.println(Thread.currentThread().getName());
        }
    }
}
