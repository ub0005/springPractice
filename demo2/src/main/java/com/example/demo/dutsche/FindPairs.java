package com.example.demo.dutsche;

import org.hibernate.internal.build.AllowSysOut;

public class FindPairs {

	public static void main(String[] args) {

		int[] arr = new int[] {1,1,13,1,5,5,1,5,6,6,5,1, 13, 12, 12, 1};
		
		//System.out.println(arr.length/2);

		System.out.println(solution(arr));
		

		// iterate through the array, compare each element with rest of the elements
		// if there is a match found, replace those elements with a specific number (-0)
	}

	private static boolean solution(int[] arr) {
		
		boolean matchFound = false;
		
		int count=0;
		
		if (arr.length % 2 !=0) {
			return false;
		}
		
		for (int i = 0; i < arr.length-1; i++) {
			
			if (arr[i] == -9999) {
				continue;
			}
			matchFound = false;
			for (int j = i + 1; j < arr.length; j++) {

				if (arr[i] == arr[j]) {
					matchFound = true;
					arr[j] = -9999;
					break;
				}
			}
			if (matchFound == false) {
				return false;
			} else {
				count = count +1;
			}
		}
		
		int halfCount = arr.length/2;
		if (count == halfCount) {
			return true;
		} else {
			return false;
		}
	}

}
