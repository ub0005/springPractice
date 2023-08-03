package com.example.demo.Hw4;

public class ParthuDistinctNumbers {
	
	public static void main(String[] args) {
		int a[] = {1,1,1,2,3,4,5};
		int left =0;
		int right = a.length-1;
		distinctNumbers(a, left, right);
	}

	private static int distinctNumbers(int[] a, int left, int right) {
		if (left == right) {
			return a[left];
		} else {
			
		}
		return right;
	}

}
