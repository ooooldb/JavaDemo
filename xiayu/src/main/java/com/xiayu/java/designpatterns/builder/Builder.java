package com.xiayu.java.designpatterns.builder;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public abstract class Builder {
    //设置产品的不同部分，以获得不同的产品
    public abstract void setPart1();

    public abstract void setPart2();
    //建造产品
    public abstract Product buildProduct();
}
