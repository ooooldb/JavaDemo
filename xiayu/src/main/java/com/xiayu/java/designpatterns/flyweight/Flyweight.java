package com.xiayu.java.designpatterns.flyweight;

/**
 * @author: starc
 * @date: 2019/1/29
 */
public abstract class Flyweight {
    private String intrinsic;
    protected final String Extrinsic;
    public Flyweight(String _Extrinsic){
        this.Extrinsic=_Extrinsic;
    }
    public abstract void operate();

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
