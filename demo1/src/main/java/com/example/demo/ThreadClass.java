package com.example.demo;

public class ThreadClass extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i=0; i<100; i++) {
			System.out.println("I am printed by child thread");
		}
	}
	
	public static void main(String[] args) {
//		ThreadClass threadclass = new ThreadClass();
//		threadclass.start();
//		
		for (int i=0; i<100; i++) {
			System.out.println("I am printed by main thread");
		}
		RunnableDemo runnableDemo = new RunnableDemo();
		
		Thread thread  = new Thread(runnableDemo);
		thread.start();
		
	}

}
