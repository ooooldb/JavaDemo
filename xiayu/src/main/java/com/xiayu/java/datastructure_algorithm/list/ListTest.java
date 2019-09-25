package com.xiayu.java.datastructure_algorithm.list;

import org.junit.Test;

/**
 * @author: starc
 * @date: 2019/1/4
 */
public class ListTest {
    @Test
    public void test() {
        MyStack<Integer> stack = new MyStack<Integer>();
        for (int i = 0; i < 1000; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void test1() {
        MyQueue<Integer> quene = new MyQueue<Integer>();
        for (int i = 0; i < 1000; i++) {
            quene.enqueue(i);
        }
        for (int i = 0; i < 1000; i++) {
            System.out.println(quene.dequeue());
        }
    }

    @Test
    public void test2() {
        int flag = 0;
        for (int i = 'a'; i <= 'z'; i++) {
            for (int j = 1; j < 124 - i; j++) {
                hello((char) i, j, "");
                flag++;
            }
            //for(int j=0;j)
        }
        System.out.println(flag);
    }

    // a 1 ""
    // a 2 "ab" "ac"
    public void hello(char c, int a, String str) {
        if (a == 1) {
            System.out.println(c + str);
        } else {
            for (int i = c + 1; i <= 'z'; i++) {
                hello((char) i, a - 1, (char) (i) + str);
            }
        }
    }

    public void fuck(char c, int len, String str) {
        if (len == 1) {
            for (int i = c; i <= 'z'; i++) {
                System.out.println(c + str + (char) i);
            }
        } else {
            for (int i = c; i <= 'z'; i++) {

            }
        }
    }

    @Test
    public void test3() {
        hello('a', 3, "");
    }
}
