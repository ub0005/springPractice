package com.example.demo.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
	
	public static void main(String[] args) {
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		Employee[] myarr = new Employee[3];
		
		
		Employee empl1 = new Employee();
		empl1.setId(2);
		empl1.setFirstName("Uday");
		empl1.setLastName("Bommala");
		empl1.setEmployeeID(1);
		empl1.setCity("Huntsville");
		empl1.setAge(21);
		
		Employee empl2 = new Employee();
		empl2.setId(1);
		empl2.setFirstName("Tushar");
		empl2.setLastName("Varma");
		empl2.setEmployeeID(2);
		empl2.setCity("Knoxville");
		empl2.setAge(19);
		
		Employee empl3 = new Employee();
		empl3.setId(3);
		empl3.setFirstName("Charan");
		empl3.setLastName("Pottabathini");
		empl3.setEmployeeID(3);
		empl3.setCity("Cary");
		empl3.setAge(20);
		
		employeeList.add(empl1);
		employeeList.add(empl2);
		employeeList.add(empl3);
		
		myarr[0] = empl1;
		myarr[1] = empl2;
		myarr[2] = empl3;
		
//		Arrays.stream(myarr).forEach(e -> System.out.println(e.getFirstName()));
		
		Arrays.sort(myarr, new AgeComparator());
		
		Arrays.stream(myarr).forEach(e ->{
			System.out.println(e.getFirstName()+ " "+ e.getAge());
		});
		
		
		
		
	}
	
}
