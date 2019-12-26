package com.xiayu.java.designpatterns.proxy;

/**
 * 代理模式
 * 为其他对象提供一种代理以控制对这个对象的访问。
 * @author: starc
 * @date: 2019/1/28
 */
public class Proxy implements Subject{
    private Subject subject = null;

    public Proxy(){
        subject=new Proxy();
    }
    public Proxy(Subject _subject){
        this.subject = _subject;
    }

    @Override
    public void request() {
        before();
        subject.request();
        after();
    }

    private void before(){

    }
    private void after(){

    }
}

