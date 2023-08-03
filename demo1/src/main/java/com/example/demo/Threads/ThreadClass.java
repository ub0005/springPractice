package com.example.demo.Threads;

public class ThreadClass extends Thread {
	
	@Override
	public void run() {
		for(int i =0; i<20; i++) {
			System.out.println("Printed by Child Thread class "+ i);
		}
	}
}
