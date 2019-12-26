package com.xiayu.java.java.collection;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author: test_
 * @date: 2019/11/25
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.naturalOrder());
        for (int i = 20; i > 0; i--) {
            treeSet.add(i);
        }
        System.out.println(treeSet);

    }
}
