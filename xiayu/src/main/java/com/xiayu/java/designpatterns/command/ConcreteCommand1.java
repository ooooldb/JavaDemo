package com.xiayu.java.designpatterns.command;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class ConcreteCommand1 extends Command {
    private Receiver receiver;

    public ConcreteCommand1(Receiver _receiver){
        receiver=_receiver;
    }
    @Override
    public void excute() {
        this.receiver.doSomething();
    }
}
