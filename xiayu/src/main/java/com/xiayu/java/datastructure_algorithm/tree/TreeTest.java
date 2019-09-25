package com.xiayu.java.datastructure_algorithm.tree;

import org.junit.Test;

/**
 * @author: starc
 * @date: 2019/1/7
 */
public class TreeTest {

    @Test
    public void test() {
        AvlTree tree = new AvlTree();
        for (int i = 0; i < 1000000; i++) {
            tree.add(i);
        }
        for (int i = 0; i < 1000000; i=i+2) {
            tree.delete(i);
        }
        tree.heightCheck();
    }
    @Test
    public void test1() {
        BinarySearchTree tree = new BinarySearchTree();
        for (int i = 0; i < 1000; i++) {
            tree.add(i);
        }
        tree.print();
        for (int i = 0; i < 100; i++) {
            tree.delete(i);
        }
        System.out.println(tree.printMax());
        System.out.println(tree.findMin());

    }
    @Test
    public void test2() {
        new Demo().print();

    }

}
