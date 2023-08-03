package com.example.demo.hm2;

public class inversionCountBruteForce {
	
	static int inversionCount=0;
	
	public static void main (String[] args) {
		int[] inversionArray = new int[] {12,11,10,9,8,7,6,5,4,3,2,1};
		int len = inversionArray.length;
		int inversionCount = 0;
		for (int i=0; i<len-1; i++) {
			for (int j=i+1; j<len;j++) {
				if (inversionArray[i] > inversionArray[j]) {
					inversionCount++;
				}
			}
		}
		System.out.println("inversionCount is " + inversionCount);
	}
}
