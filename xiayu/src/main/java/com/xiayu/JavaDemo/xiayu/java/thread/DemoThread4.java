package com.xiayu.JavaDemo.xiayu.java.thread;

/**
 * @author: starc
 * @date: 2018/12/17
 */
public class DemoThread4 implements Runnable {

    @Override
    public void run() {
        synchronized (DemoThread2.class) {
            System.out.println("天");
            System.out.println("气");
            System.out.println("还");
            System.out.println("不");
            System.out.println("错");
            System.out.println("呢");
            System.out.println("哈");
            System.out.println("哈");
            System.out.println("哈");
            System.out.println("！");
        }
    }
}
