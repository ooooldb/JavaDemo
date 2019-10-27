package com.xiayu.java.datastructure.tree;

import javax.xml.soap.Node;

/**
 * @author: test_
 * @date: 2019/10/26
 */
public class RedBlackTree {

    private Node nil = new Node(null, Color.Black);
    private Node root = nil;

    public void insert(int value) {
        Node node = new Node(value, Color.Red);
        Node parent = nil;
        Node now = root;
        while (now != nil) {
            if (value > now.value)
                now = now.right;
            else
                now = now.left;
            parent = now;
        }
        if (parent == nil)
            root = node;
        node.parent = parent;
        if (parent.value > value)
            parent.left = node;
        else
            parent.right = node;
        insertFixUp(root,node);
    }

    private void insertFixUp(Node root, Node node) {

    }

    private class Node {
        Node left = nil;
        Node right = nil;
        Node parent = nil;
        Integer value;
        Color color;

        Node(Integer value, Color color) {
            this.value = value;
            this.color = color;
        }
    }

    enum Color {
        Red, Black
    }
}

