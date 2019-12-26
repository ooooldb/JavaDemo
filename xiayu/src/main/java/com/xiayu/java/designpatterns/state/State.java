package com.xiayu.java.designpatterns.state;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public abstract class State {
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void handler1();

    public abstract void handler2();
}
