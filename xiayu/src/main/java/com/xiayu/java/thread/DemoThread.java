package com.xiayu.java.thread;

/**
 * @author: starc
 * @date: 2018/12/16
 */
public class DemoThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
        }
    }
    public static void main(String[] args) {
        DemoThread demoThread = new DemoThread();
        //新建一个Thread对象
        Thread thread = new Thread(demoThread);
        //输出它的状态
        System.out.println(thread.getState());
        //调用它的start方法后输出它的状态
        thread.start();
        System.out.println(thread.getState());
    }
}
