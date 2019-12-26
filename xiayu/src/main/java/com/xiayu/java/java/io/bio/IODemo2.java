package com.xiayu.java.java.io.bio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author: starc
 * @date: 2019/2/17
 */
public class IODemo2 {
    /**
     * 一个简单的文件输入输出流
     * 一次传送一个字节
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\abc.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\fuck.txt");
        //read()，返回读取的字节
        int read;
        while ((read = fileInputStream.read()) != -1) {
            //write(int)写入字节
            fileOutputStream.write(read);
            read = fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    /**
     * 将file内的数据装入一个数组，一次性写入输出流中。
     * 缺点:文件太大可能会内存溢出。
     *
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\abc.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\fuck.txt");
        //available()获取输入流文件的字节个数
        byte[] arr = new byte[fileInputStream.available()];
        int read = fileInputStream.read(arr);
        if (read != -1) {
            fileOutputStream.write(arr);
        }
        System.out.println(read);
        fileInputStream.close();
        fileOutputStream.close();
    }

    @Test
    public void test2() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\abc.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\fuck.txt");
        //skip(long n)跳过的字节数，返回实际跳过的值
        System.out.println(fileInputStream.markSupported());
        /*int read = fileInputStream.read();
        fileInputStream.mark(1);
        while (read != -1) {
            fileOutputStream.write(read);
            read=fileInputStream.read();
        }
        fileInputStream.reset();
        read = fileInputStream.read();
        while (read != -1) {
            fileOutputStream.write(read);
            read=fileInputStream.read();
        }
        fileInputStream.close();
        fileOutputStream.close();*/
    }

    @Test
    public void test3() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\abc.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\fuck.txt");
        int read;
        while ((read = fileInputStream.read()) != -1) {
        }
    }
}
