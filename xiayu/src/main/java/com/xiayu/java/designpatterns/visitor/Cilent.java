package com.xiayu.java.designpatterns.visitor;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class Cilent {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Element el =ObjectStructure.createElement();
            el.accept(new Visitor());
        }
    }
}
