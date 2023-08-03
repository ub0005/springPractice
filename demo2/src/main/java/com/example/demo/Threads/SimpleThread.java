package com.example.demo.Threads;

import java.util.stream.Stream;

public class SimpleThread extends Thread {

	public void run( ) {
		Stream.of(1, 4, 5, 23, 65, 89, 43).forEach(x -> System.out.println(x + "printed by simple thread"));
	}
}
