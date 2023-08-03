package com.example.demo.service;

public class reverseAString {
	
	public static void main(String[] args) {
		
		String str1 = "Uday";
		
		String str2 = "";
		
		for (int i=0; i< str1.length(); i++) {
			str2 = str1.charAt(i) + str2;
		}
		
		System.out.println(str2);
		
		
		// read from begin 
		// read from end
		// stop when i = j
		
		int i=0;
		int j=str1.length()-1;
		
		char[] charArray = str1.toCharArray();
		
		//char[] newCharArray = new char[4];
		while (i <= j) {
			charArray[i] = str1.charAt(j);
			charArray[j] = str1.charAt(i);
			i++;
			j--;
		}
		System.out.println(new String(charArray));
	}

}
