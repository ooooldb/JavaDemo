package com.xiayu.JavaDemo.xiayu.java.java.io.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author: starc
 * @date: 2019/2/17
 */
public class FileDemo {
    @Test
    public void test1() {
        //windows系统中分隔符为\;Java中字符串直接写路径名时需要加\转义
        File file = new File("D:\\abc.txt");
        //判断是否存在文件/文件夹
        System.out.println(file.exists());
        //判断是否是文件夹
        System.out.println(file.isDirectory());
        //判断是否是文件
        System.out.println(file.isFile());
        //判断是否是隐藏文件
        System.out.println(file.isHidden());
        //判断是否可读
        System.out.println(file.canRead());
        //判断是否可写
        System.out.println(file.canWrite());
    }
    @Test
    public void test2() {
        //windows系统中分隔符为\;Java中字符串直接写路径名时需要加\转义
        String path="D:";
        String path2="abc.txt";
        String path3=path+File.separator+path2;
        File file = new File(path3);
        System.out.println(file.exists());
        //;
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        //\
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
    }
    @Test
    public void test3() throws IOException {
        //抽象路径，即当前项目路径下
        File file = new File("hello1.txt");
        file.createNewFile();
        file.renameTo(new File("hello2.txt"));
        //删不掉hello2.txt,路径不一样了.
        file.delete();
    }


}
