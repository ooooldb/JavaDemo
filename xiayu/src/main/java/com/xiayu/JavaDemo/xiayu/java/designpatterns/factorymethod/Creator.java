package com.xiayu.JavaDemo.xiayu.java.designpatterns.factorymethod;

/**
 * @author: starc
 * @date: 2019/1/27
 */
public abstract class Creator {

    public abstract <T extends Product> T createProduct(Class<T> c);
}
