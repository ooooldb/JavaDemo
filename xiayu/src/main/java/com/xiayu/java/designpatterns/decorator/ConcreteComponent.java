package com.xiayu.java.designpatterns.decorator;

/**
 * @author: starc
 * @date: 2019/1/27
 */
public class ConcreteComponent implements Component {

    @Override
    public void methodA() {
        System.out.println("do something");
    }
}
