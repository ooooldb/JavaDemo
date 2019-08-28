package com.xiayu.JavaDemo.xiayu.java.thread;

/**
 * @author starc
 */
public class SecondThread implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}
	public static void main(String[] args) {
		new Thread(new SecondThread()).start();
	}
}
