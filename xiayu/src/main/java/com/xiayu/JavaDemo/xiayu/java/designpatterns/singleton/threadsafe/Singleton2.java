package com.xiayu.JavaDemo.xiayu.java.designpatterns.singleton.threadsafe;


/**
 * @author: starc
 * @date: 2019/1/27
 */
public class Singleton2 {
    private static Singleton2 singleton = new Singleton2();

    private Singleton2() {
        //定义的构造函数是私有的，无法通过new来得到这个类的实例。
    }

    /**
     * 2.在静态初始化器中创建类实例，JVM在加载这个类时会初始化singleton，JVM保证这个过程是线程安全的。
     * 缺点是不再是延迟实例化了。
     *
     * @return 类实例
     */
    public static Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
