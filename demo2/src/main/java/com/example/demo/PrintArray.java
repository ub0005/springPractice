package com.example.demo;

import java.util.Arrays;
import java.util.List;

public class PrintArray {
	
	public static void main(String[] args) {
		
		Integer[] intArray = new Integer[7];
		intArray[0] = 45;
		intArray[1] = 65;
		intArray[2] = 23;
		intArray[3] = 89;
		intArray[4] = 44;
		intArray[5] = 34;
		intArray[6] = 99;
		
		for (int i=0; i< intArray.length; i++) {
			//System.out.println(intArray[i]);
		}
		List<Integer> arrayList = Arrays.asList(intArray);
		//arrayList.stream().forEach(x -> System.out.println(x));
		
		List<Integer> simpleList = List.of(1,5,7,9,12,54,2,32,14, 54);
		
		
		System.out.println(simpleList.indexOf(54));
		//simpleList.stream().sorted().forEach(x -> System.out.println(x));
	}

}
