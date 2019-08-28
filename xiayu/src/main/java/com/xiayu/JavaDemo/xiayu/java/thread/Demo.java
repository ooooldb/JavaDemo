package com.xiayu.JavaDemo.xiayu.java.thread;

import org.junit.Test;

/**
 * @author: starc
 * @date: 2018/12/17
 */
public class Demo {

    @Test
    public void test1() {
        DemoThread2 t1 = new DemoThread2();
        DemoThread2 t2 = new DemoThread2();
        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t2);
        tt1.start();
        tt2.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println("tt1 " + tt1.getState());
            System.out.println("tt2 " + tt2.getState());
        }
    }

    @Test
    public void test2() {
        DemoThread2 t1 = new DemoThread2();
        DemoThread4 t2 = new DemoThread4();
        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t2);
        tt1.start();
        tt2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("tt1 " + tt1.getState());
            System.out.println("tt2 " + tt2.getState());
        }
    }

    @Test
    public void test3() {
        //System.out.println(Thread.currentThread().getPriority()); 5
        //新建一个Thread对象
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println("i");
            }
        });
        //输出它的状态 New
        System.out.println(t1.getState());
        //调用它的start方法后输出它的状态 Runnable
        t1.start();
        System.out.println(t1.getState());
    }

    /**
     * runnable -> blocked
     */
    @Test
    public void test4() {
        //创建一个线程t1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //该线程获得String的class对象锁后一直持有
                synchronized (String.class) {
                    while (true) {
                    }
                }
            }
        });
        //创建线程t2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    //运行到这里,访问它的状态为Runnable
                }
                //运行到这里，一般来说String的class对象锁已被t1持有,线程状态由Runnable -> Blocked
                synchronized (String.class) {

                }
            }
        });
        t1.start();
        t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(t2.getName() + " " + t2.getState());
        }
    }

    /**
     * Runnable -> Wait
     * 1.Object.wait();
     */
    @Test
    public void test5() {
        //创建一个线程t1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (String.class) {
                    try {
                        //wait(),notify(),notifyAll()的机制是建立在被获得对象锁的对象上的
                        String.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(t1.getState());
        }
    }

    /**
     * Runnable -> Wait
     * 2.Thread.join();
     */
    @Test
    public void test6() {
        //创建一个线程t1
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //插完队来个死循环，更容易观察结果
                while (true) {
                }
            }
        });
        //创建一个线程t2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    //这里t1还是Runnable状态
                }
                try {
                    //t1 join,t2变成Waiting状态,等待t2执行完成
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(t2.getState());
        }
    }

    /**
     * time waiting
     * 1.Thread.sleep(long millis)
     */
    @Test
    public void test7() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(t1.getState());
        }
    }

    /**
     * 2.Object.wait(long millis)
     * 线程等待millis毫秒，还未被唤醒进入Runnable
     */
    @Test
    public void test8() {
        //创建一个线程t1

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (String.class) {
                    try {
                        String.class.wait(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(t1.getState());
        }
    }

    /**
     * 测试join(long millis)
     */
    @Test
    public void test9() {
        //创建一个线程t1
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                }
            }
        });
        //创建一个线程t1
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    if (i == 1000) {
                        try {
                            t1.join(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                for (int i = 0; i < 1000; i++) {

                }
            }
        });
        t1.start();
        t2.start();
        for (int i = 0; i < 100; i++) {
            System.out.println(t2.getState());
        }
    }

    /**
     * 测试yield()
     */
    @Test
    public void test10() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                    Thread.yield();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        });
        t2.setPriority(10);
        t1.setPriority(5);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    /**
     * 测试优先级
     */
    @Test
    public void test11() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        });
        /*t1.setPriority(10);*/
        t1.start();
        t2.start();
        for (int i = 0; i < 10000; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }


    @Test
    public void test12() {
        boolean flag = false;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Object o = new Object();
                synchronized (o) {
                    System.out.println(o.hashCode());
                    System.out.println("发完了");
                }
            }
        });
        t1.start();

    }

    @Test
    public void test13() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; ; i++) {
                    System.out.println(Thread.currentThread().getName() + " " + i);
                }
            }
        });
        t1.start();
        Thread.sleep(100);
        for (int i = 0; i < 10000; i++) {
            System.out.println(t1.getState());
        }
    }

    /**
     * 测试中断线程
     *
     * @throws InterruptedException
     */
    @Test
    public void test14() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; ; i++) {
                    //死循环输出isInterrupted()的返回结果
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t1.start();
        Thread.sleep(10);
        //调用interrupt()方法
        t1.interrupt();
    }

    @Test
    public void test15() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; ; i++) {
                    System.out.println("t1 is running");
                }
            }
        });
        t1.start();
        Thread.sleep(10);
        t1.interrupt();
        System.out.println("中断已经调用");
    }

    @Test
    public void test16() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        try {
                            Thread.sleep(100000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return;
                    } else {
                        System.out.println("t1 is running");
                    }
                }
            }
        });
        t1.start();
        Thread.sleep(10);
        t1.interrupt();
        System.out.println("中断方法已经调用");
    }

    /**
     * interrupt和sleep方法
     * @throws InterruptedException
     */
    @Test
    public void test17() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().isInterrupted());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        t1.start();
        Thread.sleep(10);
        t1.interrupt();
        System.out.println("中断方法已经调用");
    }
    @Test
    public void test18() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("running");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t1.interrupt();
        Thread.sleep(100);
        System.out.println("hello");
        t1.start();
    }
}
