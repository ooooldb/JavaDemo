package com.xiayu.java.java.base.extend;

/**
 * @author: test_
 * @date: 2019/11/21
 */
public class Parent {
    public String string = "hello";

    Parent(String string) {
        this.string = string;
    }
    public void append(String string) {
        this.string += string;
    }

    protected String getString() {
        return string;
    }

    public final void hello() {

    }

    private void hell1o() {

    }
}
