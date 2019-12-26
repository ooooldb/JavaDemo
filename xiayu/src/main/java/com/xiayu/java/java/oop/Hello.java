package com.xiayu.java.java.oop;

/**
 * @author: starc
 * @date: 2019/7/7
 */
public class Hello {
    public static void main(String[] args) {
        People people = new People();
        System.out.println(people.hashCode());
        fuck(people);
        System.out.println(people.hashCode());
    }
    public static void fuck(People people){
        people = new People();
        System.out.println(people.hashCode());
    }
}

class People{

}