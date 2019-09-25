package com.xiayu.java.thread;

/**
 * @author starc
 */
public class FirstThread extends Thread{

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName()+" "+i);
		}                                            
	}
	public static void main(String[] args) {
		new FirstThread().start();
		new Thread(new SecondThread()).start();
	}
}
