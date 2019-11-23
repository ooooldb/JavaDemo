package com.xiayu.java.java.base.extend;

/**
 * @author: test_
 * @date: 2019/11/22
 */
public class GrandChild extends Child {
    public String string = "hello11";
    public void hello1() {
        super.getString();
    }

    public static void main(String[] args) {
        Parent parent = new GrandChild();
        System.out.println(parent.string);
    }
}
