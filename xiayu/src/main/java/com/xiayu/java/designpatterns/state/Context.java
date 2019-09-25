package com.xiayu.java.designpatterns.state;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class Context {
    public final static State STATE1=new ConcreteState1();
    public final static State STATE2=new ConcreteState2();
    private State currentState;

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }
    public void handler1(){
        currentState.handler1();
    }
    public void handler2(){
        currentState.handler2();
    }
}
