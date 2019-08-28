package com.xiayu.JavaDemo.xiayu.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author starc
 */
public class ThirdThread implements Callable<Integer>{

	@Override
	public Integer call() {
		return 1;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<Integer> futureTask = new FutureTask<>(new ThirdThread());
		new Thread(futureTask).start();
		Integer i = futureTask.get();
		System.out.println(i);
	}
}
