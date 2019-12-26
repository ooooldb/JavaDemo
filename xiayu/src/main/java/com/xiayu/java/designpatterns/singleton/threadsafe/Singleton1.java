package com.xiayu.java.designpatterns.singleton.threadsafe;


/**
 * @author: starc
 * @date: 2019/1/27
 */
public class Singleton1 {
    private static Singleton1 singleton = null;

    private Singleton1() {
        //定义的构造函数是私有的，无法通过new来得到这个类的实例。
    }

    /**
     * 1.让getInstance()变成同步方法
     * 缺点是性能低下，实际上只有第一次执行该方法才需要同步。
     *
     * @return 类实例
     */
    public static synchronized Singleton1 getInstance() {
        if (singleton == null) {
            singleton = new Singleton1();
        }
        return singleton;
    }
}
