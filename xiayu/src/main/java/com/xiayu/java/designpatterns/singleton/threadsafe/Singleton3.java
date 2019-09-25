package com.xiayu.java.designpatterns.singleton.threadsafe;


/**
 * @author: starc
 * @date: 2019/1/27
 */
public class Singleton3 {
    private volatile static Singleton3 singleton = null;

    private Singleton3() {
        //定义的构造函数是私有的，无法通过new来得到这个类的实例。
    }

    /**
     * 3.用"双重检查加锁",在getInstance()中减少使用同步
     * 用volatile修饰singleton，保证了对所有线程的可见性
     *
     * @return 类实例
     */
    public static Singleton3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                //这一次检查是为了在防止同步代码块执行时，已经有线程等待锁，
                // 在锁释放后取得锁，如果没有检查又会new对象的情况。
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
