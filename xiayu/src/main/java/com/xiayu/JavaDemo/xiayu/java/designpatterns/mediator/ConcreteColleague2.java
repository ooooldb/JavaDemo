package com.xiayu.JavaDemo.xiayu.java.designpatterns.mediator;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class ConcreteColleague2 extends Colleague{
    public ConcreteColleague2(Mediator _mediator){
        super(_mediator);
    }
    public void selfMethod1(){

    }
    public void selfMethod2(){

    }
    public void depMethod1(){
        //处理自己的业务逻辑
        mediator.doSomething2();
    }
}
