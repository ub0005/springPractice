package com.example.demo;

public class ConcaveArray {

	public static void main(String[] args) {
		int[] a = new int[] {0,2,4,6,8,10,12,14,16,18,20,19,17,15,13,11,8,6,4,2,1,0};

		int[] temp = new int[a.length];
		int j = a.length - 1;
		int k = 0;
		int i = 0;
		while (i <= j) {
			if (a[i] < a[j]) {
				temp[k] = a[i];
				k++;
				i++;
			} else if (a[i] > a[j]) {
				temp[k] = a[j];
				k++;
				j--;
			} else {
				temp[k] = a[j];
				k++;
				j--;
			}
		}
		for (int l = 0; l < temp.length; l++) {
			System.out.println(temp[l]);
		}
	}

}
