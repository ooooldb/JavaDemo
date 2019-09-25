package com.xiayu.java.designpatterns.prototype;

/**
 * @author: starc
 * @date: 2019/1/28
 */
public class PrototypeClass implements Cloneable {
    @Override
    protected PrototypeClass clone() {
        PrototypeClass prototypeClass = null;
        try {
            prototypeClass = (PrototypeClass) super.clone();
        }catch (CloneNotSupportedException e){

        }
        return prototypeClass;
    }
}
