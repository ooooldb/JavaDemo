package com.xiayu.java.datastructure.list;

/**
 * @author: starc
 * @date: 2019/1/4
 */
public class MyArrayList<K> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;
    private Object[] data;
    private int size = 0;

    MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
    }

    MyArrayList(int capacity) {
        data = new Object[capacity];
    }

    public void add(K element) {
        if (size >= capacity) {
            addCapacity();
        }
        data[size++]=element;
    }

    private void addCapacity() {
        Object[] arr = new Object[capacity *= 2];
        for (int i = 0; i < data.length; i++) {
            arr[i] = data[i];
        }
        data = arr;
    }
}
