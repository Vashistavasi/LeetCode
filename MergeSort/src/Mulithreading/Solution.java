package Mulithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {
public static void main(String[] args) throws InterruptedException {
	Solution s=new Solution();
	CountDownLatch latch=new CountDownLatch(10);
	Task task=s.new Task(latch);
	ExecutorService e=Executors.newFixedThreadPool(3);
	
	for(int i=0;i<10;i++)
	e.submit(task);
	e.shutdown();
	latch.await();
	
	System.err.println(task.number+" answer");
}
class Task implements Runnable{
	private final CountDownLatch latch;
	int number;
Task(CountDownLatch latch){
	this.latch=latch;
	this.number=0;
}
	@Override
	public synchronized void  run() {
		// TODO Auto-generated method stub
		this.number++;
		System.out.println(Thread.currentThread()+" number: "+ number);
		System.err.println(number);
		latch.countDown();
	}
	
}
}
