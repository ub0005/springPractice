package com.example.demo.Hw4;

public class DistinctElements {

	public static void main(String[] args) {

		int a[] = {1,2,3,4,4,6,7,8};
		int count =0;
		int left =0;
		int right = a.length-1;  
		count = countDistinctElements(a, left, right, count, false);
		System.out.println(count);
	}

	private static int countDistinctElements(int[] a, int left, int right, int count, boolean skipFirst) {
		
		if (a[left] == a[right]) {
			if (!skipFirst) {
				count = count+1;
				return count;
			}
		} else {
			int mid = (left + right )/2;
			count = countDistinctElements(a, left, mid, count, skipFirst);
			count = countDistinctElements(a, mid+1, right, count, a[mid] == a[mid + 1]);
		}
		return count;
	}
		
}
