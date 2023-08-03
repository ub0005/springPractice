package com.example.demo;

public class ConcaveRecursive {

	public static void main(String[] args) {
		int[] a = new int[] {0,2,4,6,8,10,12,14,16,18,20,19,17,15,13,11,8,6,4,2,1,0};

		int[] temp = new int[a.length];
		int j = a.length - 1;
		int k = 0;
		int i = 0;
		int[] sortedArray = sort(i, j, k, temp, a);
		for (int l = 0; l < sortedArray.length; l++) {
			System.out.println(temp[l]);
		}
	}

	static int[] sort(int i, int j, int k, int[] temp, int[] a) {
		if (i <= j) {
			if (a[i] < a[j]) {
				temp[k] = a[i];
				return sort(i+1, j, k+1, temp, a);
			} else if (a[i] >= a[j]) {
				temp[k] = a[j];
				return sort(i, j-1, k+1, temp, a);
			}
		}
		return temp;
	}
}
