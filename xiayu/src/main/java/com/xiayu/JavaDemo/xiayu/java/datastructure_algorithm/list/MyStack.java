package com.xiayu.JavaDemo.xiayu.java.datastructure_algorithm.list;

/**
 * @author: starc
 * @date: 2019/1/4
 */
public class MyStack<K> {
    /**
     * DEFAULT_CAPACITY：初始的栈大小
     * capacity：此时栈的大小
     * data：存储元素的Object数组
     * size：栈内元素个数
     */
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;
    private Object[] data;
    private int size = 0;

    MyStack() {
        data = new Object[capacity];
    }

    MyStack(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public K pop() {
        //return size > 0 ? (K) data[--size] : throw new IndexOutOfBoundsException();
        if (!isEmpty()) {
            return (K) data[--size];
        }
        throw new IndexOutOfBoundsException();
    }

    public void push(K element) {
        if (size() >= capacity) {
            addCapacity();
        }
        data[size++] = element;
    }

    private void addCapacity() {
        Object[] arr = new Object[capacity *= 2];
//        for (int i = 0; i < data.length; i++) {
//            arr[i] = data[i];
//        }
        System.arraycopy(data,0,arr,0,data.length);
        data = arr;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }
}
