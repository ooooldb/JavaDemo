package com.xiayu.JavaDemo.xiayu.java.designpatterns.templatemethod;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public abstract class AbstractClass {
    //基本方法，由子类实现的方法
    protected abstract void doSomething();
    protected abstract void doAnything();
    /*
    模板方法，可以有一个或多个。一般会用final修饰，不允许子类重写。
     */
    public void templateMethod(){
        /*
        调用基本方法，完成业务逻辑
         */
        doSomething();
        doAnything();
    }
}
