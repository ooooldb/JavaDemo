package com.xiayu.JavaDemo.xiayu.java.designpatterns.singleton;

/**
 * @author: starc
 * @date: 2019/1/27
 */
public class Singleton {
    //使用延迟实例化直到getInstance第一次被调用才初始化singleton，如果不被调用就一直不初始化，节省资源。
    private static Singleton singleton = null;

    private Singleton() {
        //定义的构造函数是私有的，外面无法通过new来得到这个类的实例。
    }

    /**
     * 得到这个类实例的唯一途径。
     *
     * @return 类实例
     */
    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
