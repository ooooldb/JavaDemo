package com.xiayu.java.designpatterns.visitor;

import java.util.Random;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class ObjectStructure {
    public static Element createElement(){
        Random rand=new Random();
        if(rand.nextInt(100)>50){
            return new ConcreteElement1();
        }else {
            return new ConcreteElement2();
        }
    }
}
