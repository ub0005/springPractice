package com.example.demo.Threads;

public class MainClass {
	
	public static void main(String[] args) {
		
		ThreadClass thread = new ThreadClass();
		//thread.start();
		
		RunnableThread runnableThread = new RunnableThread();
		
		Thread newRunnableThread =new Thread(runnableThread);
		
		newRunnableThread.start();
		
		for(int i =0; i<20; i++) {
			System.out.println("Printed by Main Thread "+ i);
		}
	}

}
