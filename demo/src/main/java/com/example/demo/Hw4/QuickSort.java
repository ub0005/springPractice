package com.example.demo.Hw4;

public class QuickSort {

	public static void main(String[] args) {

		int a[] = {1, 3, 2, 9, 8, 4, 6, 7, 5};

		quickSort(a, 0, a.length-1);

		for (int i = 0; i <= a.length - 1; i++) {
			System.out.println(a[i]);
		}
	}

	private static void quickSort(int[] a, int start, int end) {

		if (start < end) {
			int p = partition(a, start, end);
			quickSort(a, start, p - 1);
			quickSort(a, p + 1, end);
		}
	}

	private static int partition(int[] a, int start, int end) {
		int pivot = a[end];
		int pindex = start;
		for (int i = start; i < end; i++) {
			if (a[i] <= pivot) {
				int a1 = a[i];
				int a2 = a[pindex];
				a[pindex] = a1;
				a[i] = a2;
				pindex = pindex + 1;
			}
		}
		// swap (a[pindex], a[end])
		int a1 = a[end];
		int a2 = a[pindex];
		a[pindex] = a1;
		a[end] = a2;
		return pindex;
	}
}
