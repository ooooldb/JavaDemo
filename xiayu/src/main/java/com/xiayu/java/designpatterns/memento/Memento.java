package com.xiayu.java.designpatterns.memento;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class Memento {
    private String state="";
    public Memento(String _state) {
        this.state=_state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
