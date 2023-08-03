package com.example.demo;

import java.util.Arrays;

public class Sorting {

	public static void main(String[] args) {

		Employee[] empArray = new Employee[4];
		
		Employee emp1 = new Employee(5, "Uday Kumar", "Bommala");
		Employee emp2 = new Employee(2, "Siddarrtha", "Yerra");
		Employee emp3 = new Employee(8, "Bhargav", "Kommineni");
		Employee emp4 = new Employee(34, "RK", "Chintha");
		
		empArray[0] = emp1;
		empArray[1] = emp2;
		empArray[2] = emp3;
		empArray[3] = emp4;
		
		//Arrays.sort(empArray);
		
		//Arrays.asList(empArray).stream().sorted().forEach(x -> System.out.println(x.getFirstName()));
		
		Arrays.asList(empArray).stream().sorted((x, y) -> y.getFirstName().compareTo(x.getFirstName())).forEach(x -> System.out.println(x.getFirstName()));
		
		// sorting by with out java methods
		
		Integer[] intArray = new Integer[] {34, 54, 23, 12, 67, 89, 45, 38, 88, 99};
		
		for (int i=0; i<intArray.length; i++) {
			Arrays.asList(intArray).stream().forEach(x -> System.out.println(x));
			for (int j=i+1; j< intArray.length; j++) {
				if(intArray[i] > intArray[j]) {
					int temp = intArray[i];
					intArray[i] = intArray[j];
					intArray[j] = temp;
				}
			}
			System.out.println(" ");
		}
		
		Arrays.asList(intArray).stream().forEach(x -> System.out.println(x));
	}

}
