package com.xiayu.java.java.base.extend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        /*Parent parent = new GrandChild();
        System.out.println(parent.string);*/
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strings.add(i + "");
        }
        System.out.println(strings.size());
    }
}
