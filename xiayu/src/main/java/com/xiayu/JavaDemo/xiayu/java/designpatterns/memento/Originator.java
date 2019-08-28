package com.xiayu.JavaDemo.xiayu.java.designpatterns.memento;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class Originator {
    private String state="";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    public Memento createMemento(){
        return new Memento(state);
    }
    public void restoreMemento(Memento _memento){
        setState(_memento.getState());
    }
}
