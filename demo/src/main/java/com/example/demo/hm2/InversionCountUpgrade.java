package com.example.demo.hm2;

public class InversionCountUpgrade {

	public static void main(String[] args) {
		int[] inversionArray = new int[] {0,1,2,3,4,5,6,7,8,9};
		int count = mergeSort(inversionArray, inversionArray.length);
		System.out.println(count);
	}

	public static int mergeSort(int[] a, int n) {
		int inversionsCount = 0;

		if (n < 2) {
			return 0;
		}
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		inversionsCount += mergeSort(l, mid);
		inversionsCount += mergeSort(r, n - mid);

		inversionsCount += merge(a, l, r, mid, n - mid);
		return inversionsCount;

	}

	public static int merge(int[] a, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		int inversionsCount = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			} else {
				a[k++] = r[j++];
				inversionsCount += left - i;
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
		return inversionsCount;
	}

}
