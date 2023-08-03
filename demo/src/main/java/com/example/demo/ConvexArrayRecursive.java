package com.example.demo;

public class ConvexArrayRecursive {
	
	public static void main(String[] args) {
		
		int[] a = new int[] {0,1,2,3,4,6,7,8,23,54,76};
		
		int m  = convexArrayRecursive(a, 0, a.length-1);
		System.out.println(m);
	}

	private static int convexArrayRecursive(int[] a, int left, int right) {
		int m =0;
		int n = a.length;
		if (n == 1) {
			return a[0];
		} else if (n ==0) {
			return 0;
		}
		if (right != left && (right - left) != 1) {
			m = (left + right)/2;
			if (a[m] > a[m+1] && a[m] < a[m-1]) {
				return convexArrayRecursive(a, m+1, right);
			} else {
				return convexArrayRecursive(a, left, m);
			}
		} else {
			if (a[left] < a[right]) {	
				return a[left];
			} else {
				return a[right];
			}
		}
	}

}
