package com.xiayu.JavaDemo.xiayu.java.thread;

/**
 * @author: starc
 * @date: 2019/1/1
 */
public class InterruptThread extends Thread {
    private volatile static boolean on = false;

    @Override
    public void run() {
        while (!on) {
            System.out.println("running");
        }

        System.out.println("stop");
    }

    public void stopThread() {
        on = true;
    }

    public static void main(String[] args) throws InterruptedException {
        InterruptThread t1 = new InterruptThread();
        t1.start();
        Thread.sleep(100);
        t1.stopThread();
        System.out.println("stop thread");
    }
}
