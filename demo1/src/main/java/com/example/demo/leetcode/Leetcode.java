package com.example.demo.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Leetcode {

	// print the elements of an array

	public static void main(String[] args) {
		int[] arr = new int[10];

		arr[0] = 43;
		arr[1] = 32;
		arr[2] = 12;
		arr[3] = 12;
		arr[4] = 78;
		arr[5] = 22;
		arr[6] = 36;
		arr[7] = 50;
		arr[8] = 12;
		arr[9] = 90;

//		for (int i=0; i< arr.length; i++) {
//			System.out.println(arr[i]);
//		}

		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		// find the sum of the elements in the array
		int sum=0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		System.out.println("Sum= "+sum);
		
		// find the highest number in the array
		
		int highestValue =0;
		for (int i=0; i<arr.length; i++) {
			if(arr[i] >= highestValue) {
				highestValue = arr[i];
			}
		}
		System.out.println("Highest Value= "+ highestValue);
		
		
		// find the lowest number in an array
		int lowestValue =arr[0];
		for (int a: arr) {
			if(a < lowestValue) {
				lowestValue = a;
			}
		}
		System.out.println("Lowest Value= " + lowestValue);
		
		// reverse a string
		
		String str1 = "Uday Kumar";
		
		
		char[] charArray = str1.toCharArray();
		
		String str2 = "";
		
		for(int i=charArray.length-1; i >=0 ;i--) {
			str2 = str2 + charArray[i];
		}
		System.out.println("Reversed String= "+ str2);
		
		str2 = "";
		
		for(char c: charArray) {
			str2 = c + str2;
		}
		System.out.println("Reversed String= "+ str2);
		
		// find the count of duplicate elements in an array
		
		Set set = new HashSet();
		long count = Arrays.stream(arr).filter(x-> !set.add(x)).count();
		
		System.out.println("Number of duplicate elements= "+ count);
		
		// find number of occurance of a character in string
		
		String str10 = "elephant";
		char c = 'e';
		int numberOfOccurances = 0;
		for(int i=0; i< str10.length();i++) {
			if (str10.charAt(i) == c) {
				numberOfOccurances++;
			}
		}
		System.out.println(numberOfOccurances);
		
		// swap two number using third variable
		
		int a = 10;
		int b = 20;
		
		System.out.println("a= "+ a + "b= "+b);
		int d = a;
		a = b;
		b = d;
		System.out.println("a= "+ a + "b= "+b);
		
		// swap with out third variable
		
		a=10;
		b=20;
		
		a = a + b;
		b = a-b;
		a = a-b; 
		System.out.println("a= "+ a + "b= "+b);
		
		
		//print duplicate elements
		
		Set set1 = new HashSet();
		Set set2 = new HashSet();
		Arrays.stream(arr).filter(x->!set1.add(x)).forEach(x-> set2.add(x));
		
		set2.forEach(x->System.out.println(x));
		
	}

}
