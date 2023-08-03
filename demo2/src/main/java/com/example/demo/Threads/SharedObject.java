package com.example.demo.Threads;

public class SharedObject {
	
	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	public synchronized void increment() {
		int x = this.getX();
		x++;
		
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		this.setX(x);
	}

}
