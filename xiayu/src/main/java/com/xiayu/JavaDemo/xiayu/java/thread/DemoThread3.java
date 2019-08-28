package com.xiayu.JavaDemo.xiayu.java.thread;

/**
 * time_waiting的测试
 * @author: starc
 * @date: 2018/12/16
 */
public class DemoThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            if(i==5000) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        DemoThread3 demoThread = new DemoThread3();
        //新建一个Thread对象
        Thread thread = new Thread(demoThread);
        //输出它的状态
        System.out.println(thread.getState());
        //调用它的start方法后输出它的状态
        thread.start();
        System.out.println(thread.getState());
        for (int i = 0; i < 10000; i++) {
            System.out.println(thread.getState());
        }


    }
}
