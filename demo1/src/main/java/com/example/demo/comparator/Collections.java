package com.example.demo.comparator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collections {
	
	public static void main(String[] args) {
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
		
		List<Employee> employeeList = new ArrayList<Employee>();
		
		employeeList.add(empl1);
		employeeList.add(empl2);
		employeeList.add(empl3);
		
		employeeList.stream().forEach(x -> System.out.println(x.getFirstName()));
		
		List<Employee> newEmployeeList = employeeList.stream().sorted(new AgeComparator()).toList();
		
		newEmployeeList.stream().forEach(x -> System.out.println(x.getFirstName()));
		
		List<Employee> employeeLinkedList = new LinkedList<Employee>();
		
		employeeLinkedList.add(empl1);
		employeeLinkedList.add(empl2);
		employeeLinkedList.add(empl3);
		
		employeeLinkedList.stream().forEach(x-> System.out.println(x.getFirstName()));
	}

}
