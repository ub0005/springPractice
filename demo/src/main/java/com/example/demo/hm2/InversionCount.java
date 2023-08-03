package com.example.demo.hm2;

import java.util.Arrays;

public class InversionCount {

	public static void main(String[] args) {
		int[] inversionArray = new int[] {3, 5, 8, 2, 6, 9, 1, 4, 10};
		int count = mergeSort(inversionArray, 0, inversionArray.length-1);
		System.out.println(count);
	}

	public static int mergeSort(int[] a, int left, int right) {
		int count = 0;
		if (left < right) {
			int mid = (left + right) / 2;
			count += mergeSort(a, 1, mid);
			count += mergeSort(a, mid + 1, right);

			count += merge(a, left, mid, right);
		}

		return count;

	}

	public static int merge(int[] a, int left, int mid, int right) {

		int[] leftArray = Arrays.copyOfRange(a, left, mid + 1);
		
		int[] rightArray = Arrays.copyOfRange(a, mid + 1, right + 1);
		
		int i = 0, j = 0, k = left, swaps = 0;
		
		while (i < leftArray.length && j < rightArray.length) {
			if (leftArray[i] <= rightArray[j]) {
				a[k++] = leftArray[i++];
			} else {
				a[k++] = rightArray[j++];
				swaps += (mid + 1) - (left + i);
			}
		}
		while (i < leftArray.length) {
			a[k++] = leftArray[i++];
		}
		while (j < rightArray.length) {
			a[k++] = rightArray[j++];
		}
		return swaps;
	}

}
