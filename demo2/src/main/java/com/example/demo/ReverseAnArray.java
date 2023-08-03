package com.example.demo;

import java.util.Arrays;

public class ReverseAnArray {
	
	public static void main(String[] args) {
		
		Integer[] intArray = new Integer[] {12, 54, 78, 98, 102};
		
		int i=0;
		int j=intArray.length-1;
		while(i<=j) {
			int temp = intArray[i];
			intArray[i] = intArray[j];
			intArray[j] = temp;
			i++;
			j--;
		}
		
		Arrays.asList(intArray).stream().forEach(x -> System.out.println(x));
		
		System.out.println("completed");
	}

}
