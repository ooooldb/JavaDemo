package com.xiayu.java.java.base.extend;

/**
 * @author: test_
 * @date: 2019/11/21
 */
public class Child extends Parent implements Cloneable {
    public Parent child = new Parent("");

    Child() {
        super("hello");
        System.out.println("hello");
    }

    public void pr() {
        super.hello();
    }
    public static void main(String[] args) {
        Child child = new Child();
        try {
            Child clone = (Child)child.clone();
            System.out.println(child.child);
            System.out.println(clone.child);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
