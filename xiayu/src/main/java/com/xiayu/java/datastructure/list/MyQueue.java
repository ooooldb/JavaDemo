package com.xiayu.java.datastructure.list;

/**
 * @author: starc
 * @date: 2019/1/4
 */
public class MyQueue<K> {
    /**
     * size：栈内元素个数
     * root：位于队头的节点（每次出队的节点）
     * tail：位于队尾的节点（每次入队的节点）
     */
    private int size = 0;
    private Node root;
    private Node tail;

    public K dequeue() {
        if (!isEmpty()) {
            K num = (K) root.item;
            root=root.next;
            size--;
            return num;
        }
        throw new NullPointerException();
    }

    public void enqueue(K item) {
        Node<K> node = new Node<>();
        node.item = item;
        if (size() == 0) {
            root = node;
        }
        if (tail != null) {
            tail.next = node;
        }
        node.prev = tail;
        tail = node;
        size++;
    }


    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    private static class Node<K> {
        K item;
        Node next;
        Node prev;
    }
}
