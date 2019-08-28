package com.xiayu.JavaDemo.xiayu.java.java.io.scanner;

import java.util.Scanner;

/**
 * @author: starc
 * @date: 2019/2/12
 */
public class Demo {
    public static void main(String[] args) {
        //构造一个Scanner对象，并与标准输入流System.in关联
        Scanner scanner = new Scanner(System.in);
        System.out.println("what is your name?");
        //nextLine()读取一行,以换行符为分隔 next()读取下一个词，以空格为分隔
        System.out.println("you name is " + scanner.nextLine());
        //nextInt(),nextDouble()也是以空格为分隔，但必须下一个为int/double，否则会报异常
        System.out.println("what is your age?");
        System.out.println("you age is " + scanner.nextInt());
    }
}
