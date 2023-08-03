package com.example.demo.mid2;

public class Mcs {


	public static void main(String[] args) {
		
		int a[] = {-1,3,2,5,-8,3,6,-1,-9,-8,-1};
		
		int left =0;
		int right = a.length -1 ;
		int total = mcs(a, left, right);
		System.out.println(total);
	}

	private static int mcs(int[] a, int left, int right) {
		
		if (left == right) {
			return a[left];
		} else {
			int mid = (left + right)/2;
			int leftsum = mcs(a, left, mid);
			int rightsum = mcs(a, mid+1, right);
			int leftmax = a[mid];
			int rightmax = a[mid+1];
			int tempsum=0;
			for (int i=mid; i>= left; i--) {
				tempsum+= a[i];
				if (tempsum > leftmax) {
					leftmax=tempsum;
				}
			}
			tempsum=0;
			for (int i=mid+1; i<= right; i++) {
				tempsum+= a[i];
				if (tempsum > rightmax) {
					rightmax = tempsum;
				}
			}
			return Math.max(Math.max(leftsum, rightsum), leftmax + rightmax);
			
		}
	}
}
