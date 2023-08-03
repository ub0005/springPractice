package com.example.demo.Hw4;

import java.util.ArrayList;
import java.util.List;

public class testing {

	public static void main(String[] args) {

		int a[] = { 1, 2,2,3,4,5};
		int count = 0;
		int left = 0;
		int right = a.length - 1;
		ArrayList<Integer> res = new ArrayList<Integer>();
		count = countDistinctElements(a, left, right, count, res);
		System.out.println(count);
	}

	private static int countDistinctElements(int[] a, int left, int right, int count, List res) {

		if (a[left] == a[right]) {
			if (!res.contains(a[left])) {
				count = count + 1;
				res.add(left, a[left]);
			}
		} else {
			int mid = (left + right) / 2;
			count = countDistinctElements(a, left, mid, count, res);
			count = countDistinctElements(a, mid + 1, right, count, res);
		}
		return count;
	}
}
