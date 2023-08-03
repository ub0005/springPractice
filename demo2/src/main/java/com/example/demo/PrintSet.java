package com.example.demo;

import java.util.Set;

public class PrintSet {
	
	public static void main(String[] args) {
		
		Set<Integer> setofElements = Set.of(11, 67, 33, 87, 23, 65, 9, 44);
		
		// order is not preserved in set
		setofElements.stream().forEach(x -> System.out.println(x));
	}

}
