package com.xiayu.java.designpatterns.builder;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class ConcreteBuilder extends Builder {
    private Product product = new Product();
    //设置产品零件
    @Override
    public void setPart1() {
        //产品类内的逻辑处理
    }

    @Override
    public void setPart2() {
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
