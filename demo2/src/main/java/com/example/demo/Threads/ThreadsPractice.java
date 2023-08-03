package com.example.demo.Threads;

public class ThreadsPractice {

	public static void main(String[] args) {

		
//		Thread thread = new Thread(new RunnableThread());
//		
//		SimpleThread simpleThread = new SimpleThread();
//		
//		thread.start();
//		simpleThread.start();
		
		SharedObject sharedObj = new SharedObject();
		
		sharedObj.setX(10);
		
		SampleThread thread1 = new SampleThread(sharedObj);
		
		SampleThread thread2 = new SampleThread(sharedObj);
		
		SampleThread thread3 = new SampleThread(sharedObj);
		
		SampleThread thread4 = new SampleThread(sharedObj);
		
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		}catch (Exception e) {

		}
		System.out.println(sharedObj.getX());
	}
}
