package com.xiayu.JavaDemo.xiayu.java.designpatterns.abstractfactory;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class Creator2 extends AbstractCreator {
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
