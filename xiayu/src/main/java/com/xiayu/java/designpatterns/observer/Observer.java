package com.xiayu.java.designpatterns.observer;

/**
 * @author: starc
 * @date: 2019/1/26
 */
public interface Observer {
    /**
     * 具体实现可以用参数在Subject和Observer之间传递信息
     */
    void update();
}
