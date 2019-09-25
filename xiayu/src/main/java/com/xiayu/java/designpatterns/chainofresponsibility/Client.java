package com.xiayu.java.designpatterns.chainofresponsibility;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class Client {
    public static void main(String[] args) {
        Handler handler1=new ConcreteHandler1();
        Handler handler2=new ConcreteHandler2();
        Handler handler3=new ConcreteHandler3();
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        Response response = handler1.handlerMessage(new Request());
    }
}
