package com.xiayu.JavaDemo.xiayu.java.designpatterns.flyweight;

import java.util.HashMap;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public class FlyweightFactory {
    private static HashMap<String,Flyweight> pool=new HashMap<>();
    public static Flyweight getFlyweight(String Extrinsic){
        Flyweight flyweight=null;
        if(pool.containsKey(Extrinsic)){
            flyweight=pool.get(Extrinsic);
        }else {
            flyweight=new ConcreteFlyweight1(Extrinsic);
            pool.put(Extrinsic,flyweight);
        }
        return flyweight;
    }
}
