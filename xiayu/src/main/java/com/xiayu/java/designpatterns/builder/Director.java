package com.xiayu.java.designpatterns.builder;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class Director {
    private Builder builder = new ConcreteBuilder();
    //构建产品
    public Product getProduct() {
        //设置不同的零件，产生不同的产品
        builder.setPart1();
        builder.setPart2();
        return builder.buildProduct();
    }
}
