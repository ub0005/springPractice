package com.example.demo;

public class DemoApplication {

	public static void main(String[] args) {
		int[] a = new int[] {15, 14, 13, 10, 9, 10, 12, 14, 16};
		int right = a.length;
		int left =0;
		int m =0;
		
		while ((right - left) != 1) {
			if ((left + right) % 2  == 1) {
				m=a[(left + right)/2];
			} else {
				m = a[(left + right + 1)/2 -1];
			}
			if (a[m] > a[m+1]) {
				left = m+1;
				right = a.length;
			} else {
				left =0;
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
