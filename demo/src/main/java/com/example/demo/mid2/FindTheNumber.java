package com.example.demo.mid2;

public class FindTheNumber {
	
	public static void main(String[] args) {
		
		int startNum = 0;
		int endNum = 100;
		int n = Integer.parseInt(args[1]);
		while (startNum != endNum) {
			if (n >= endNum) {
				startNum = endNum;
				endNum = startNum +100;
			} else {
				endNum = (endNum + startNum)/2;
				if (endNum == 0 || startNum < 0) {
					startNum = startNum -100;
				}
			}
		}
		System.out.println(startNum);

		
	}
}
