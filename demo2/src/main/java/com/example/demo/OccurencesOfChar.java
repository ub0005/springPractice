package com.example.demo;

public class OccurencesOfChar {
	
	public static void main(String[] args) {
		
		String str1 = "uday kumar";
		
		char c = 'u';
		
		int count =0;
		for (int i=0; i < str1.length(); i++) {
			if (str1.charAt(i) == c) {
				count = count +1;
			}
		}
		
		System.out.println(count);
		
	}

}
