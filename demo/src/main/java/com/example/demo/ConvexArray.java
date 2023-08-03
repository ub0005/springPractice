package com.example.demo;

public class ConvexArray {
	
	public static void main(String[] args) {
		int[] a = new int[] {0,1,2,3,4,6,7,8,23,54,76};
		int n = a.length;
		int right = n-1;
		int left =0;
		int m =0;
		if (n == 1) {
			System.out.println(a[0]);
		} else if (n == 0) {
			System.out.println(0);
		}
		
		while (left != right && (right - left) != 1) {
			
			m = (left + right)/2;
			
			if (a[m] > a[m+1] && a[m] < a[m-1]) {
				left = m+1;
			} else {
				right =m;
			}
		}
		if (a[left] < a[right]) {
			System.out.println(a[left]);
		} else {
			System.out.println(a[right]);
		}
	}
	
}
