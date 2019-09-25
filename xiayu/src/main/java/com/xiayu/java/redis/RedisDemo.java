package com.xiayu.java.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author: starc
 * @date: 2019/7/2
 */
public class RedisDemo {
    @Test
    public void stringTest() throws InterruptedException {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2. 操作
        //存储String
        jedis.set("username", "zhangsan");
        //取值
        String username = jedis.get("username");
        System.out.println(username);
        //可以使用setex()方法存储可以指定过期时间的 key value
        jedis.setex("activecode", 1, "hehe");//将activecode：hehe键值对存入redis，并且2秒后自动删除该键值对
        System.out.println("first get:" + jedis.get("activecode"));
        Thread.sleep(1000);
        System.out.println("second get:" + jedis.get("activecode"));
        //3. 关闭连接
        jedis.close();
    }

    @Test
    public void hashTest() {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2. 操作
        //存储hash
        jedis.hset("user", "zhangsan", "123");
        jedis.hset("user", "wangwu", "321");
        //取值
        String username = jedis.hget("user", "zhangsan");
        System.out.println(username);
        Map<String, String> user = jedis.hgetAll("user");
        for (Map.Entry<String, String> entry :
                user.entrySet()) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }
        //3. 关闭连接
        jedis.close();
    }

    @Test
    public void listTest() {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //2. 操作
        // list 存储
        jedis.lpush("mylist", "a", "b", "c");//从左边存
        jedis.rpush("mylist", "a", "b", "c");//从右边存

        // list 范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        // list 弹出
        String element1 = jedis.lpop("mylist");//c
        System.out.println(element1);

        String element2 = jedis.rpop("mylist");//c
        System.out.println(element2);

        // list 范围获取
        List<String> mylist2 = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist2);
        //3. 关闭连接
        jedis.close();
    }

    @Test
    public void setTest() {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // set 存储
        jedis.sadd("myset", "java", "php", "c++");

        // set 获取
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
        //3. 关闭连接
        jedis.close();
    }

    @Test
    public void sortedListTest() {
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        // sortedset 存储
        jedis.zadd("mysortedset", 3, "亚瑟");
        jedis.zadd("mysortedset", 30, "后裔");
        jedis.zadd("mysortedset", 55, "孙悟空");
        jedis.zadd("mysortedset", 40, "鲁班");
        // sortedset 获取
        Set<String> mysortedset = jedis.zrange("mysortedset", 0, -1);

        System.out.println(mysortedset);
        //3. 关闭连接
        jedis.close();
    }
}
