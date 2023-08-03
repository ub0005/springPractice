package com.example.demo.dutsche;

public class MaximumSum {

	public static void main(String[] args) {

		int number = 603;

		System.out.println(number / 10);

		System.out.println(number % 10);

		int[] arr = new int[] {23545, 24445, 12, 13, 4, 4, 15, 15, 103, 123};
		
		int maxSum = arr[0];
		
		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = i + 1; j < arr.length; j++) {
				
				if ((arr[i] < 10 && arr[j] >=10) && (arr[i] >=10 && arr[j] <10)) {
					continue;
				} else {
					
					int firstNumber = arr[i];
					int secondNumber = arr[j];
					
					if ((firstNumber %10) != (secondNumber %10)) {
						continue;
					} else {
						while (firstNumber > 10) {
							firstNumber = firstNumber/10;
						}
						while (secondNumber > 10) {
							secondNumber = secondNumber/10;
						}
						if (firstNumber == secondNumber) {
							int	sum = arr[i] + arr[j];
							if (sum > maxSum) {
								maxSum = sum;
							}
						}
					}
				}
			}
		}
		System.out.println(maxSum);
	}

}
