package com.xiayu.java.java.primitivetype;

/**
 * @author: starc
 * @date: 2019/2/10
 */
public class Demo {
    private byte a=Byte.MAX_VALUE;
    private short b=Short.MAX_VALUE;
    private int c;
    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.a= (byte) (demo.a+1);
        System.out.println(demo.a);
        demo.a= (byte) (demo.a+1);
        System.out.println(demo.a);
        demo.b= (short) (demo.b+1);
        System.out.println(demo.b+" "+Short.MIN_VALUE);
        System.out.println(demo.b);
    }
}
