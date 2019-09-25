package com.xiayu.java.thread;

/**
 * @author: starc
 * @date: 2019/6/30
 */
public class TwoThread {
    volatile static boolean flag = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 100; i = i + 2) {
                    while (flag) {
                        System.out.println(Thread.currentThread().getName() + "---" + i);
                        flag = false;
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i = i + 2) {
                    while (!flag) {
                        System.out.println(Thread.currentThread().getName() + "---" + i);
                        flag = true;
                    }
                }
            }
        }).start();
        for (int i = 0; i < 1000000; i++) {
            System.out.print("");
        }
    }

}
