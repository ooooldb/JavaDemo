package com.xiayu.java.designpatterns.mediator;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class ConcreteColleague1 extends Colleague{
    public ConcreteColleague1(Mediator _mediator){
        super(_mediator);
    }
    public void selfMethod1(){

    }
    public void selfMethod2(){

    }
    public void depMethod1(){
        //处理自己的业务逻辑
        mediator.doSomething1();
    }
}
