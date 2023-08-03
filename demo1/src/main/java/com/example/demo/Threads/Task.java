package com.example.demo.Threads;

public class Task {

	public static void main(String[] args) {
		new SubTask().start();

		new Thread(new SubTaskRunnable()).start();

		for (int i = 0; i < 1000; i++) {
			System.out.print("M");
		}
	}

}

class SubTask extends Thread {

	public void run() {
		doTask();
	}

	private void doTask() {
		for (int i = 0; i < 1000; i++) {
			System.out.print("T");
		}
	}
}

class SubTaskRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			System.out.print("R");
		}
	}

}
