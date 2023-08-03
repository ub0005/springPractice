package com.example.demo.leetocode;

public class ReverseAString {
	
	public static void main(String[] args) {
		
		String str1 = "udaykumar";
		System.out.println("Actual String: "+ str1);
		
		String reversedString = "";
		
		for(int i=0; i< str1.length();i++) {
			reversedString = str1.charAt(i) + reversedString;
		}
		System.out.println(reversedString);
		
		
		
		reversedString = "";
		
		for(int i=str1.length()-1; i>=0; i--) {
			reversedString = reversedString + str1.charAt(i);
		}
		System.out.println(reversedString);
		
		
		
		reversedString = "";
		
		char[] str1Array = str1.toCharArray();
		
		for(char c: str1Array) {
			reversedString = c + reversedString;
		}
		System.out.println(reversedString);
		
		reversedString = "";
		
		
	}

}
