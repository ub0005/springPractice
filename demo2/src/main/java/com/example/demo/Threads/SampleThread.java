package com.example.demo.Threads;

public class SampleThread extends Thread {

	private SharedObject obj;

	public SampleThread(SharedObject sharedObj) {
		this.obj = sharedObj;
	}

	public void run() {
		obj.increment();
	}
}