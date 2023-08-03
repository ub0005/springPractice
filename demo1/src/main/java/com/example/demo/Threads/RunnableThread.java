package com.example.demo.Threads;

public class RunnableThread implements Runnable{

	@Override
	public void run() {
		for(int i =0; i<20; i++) {
			System.out.println("Printed by Runnable Thread "+ i);
		}
	}

}
