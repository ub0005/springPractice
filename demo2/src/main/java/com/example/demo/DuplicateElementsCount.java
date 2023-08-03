package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateElementsCount {
	
	public static void main(String[] args) {
		
		List listOfElements = List.of(45, 23, 56, 34, 78, 29, 99, 33, 58, 98, 68, 47, 28, 47, 28);
		
		Set hashSet = new HashSet();
		
		int duplicateElementsCount = (int) listOfElements.stream().filter(x -> {
			
		boolean bool = hashSet.add(x);
		if(!bool)
			System.out.println(x);
		return !bool;
		
		}).count();
		
		System.out.println(duplicateElementsCount);
		
		
		//
		Set hashSet1 = new HashSet();
		
		for (int i=0; i< listOfElements.size(); i++) {
			if (!hashSet1.add(listOfElements.get(i))) {
				System.out.println(listOfElements.get(i));
			}
		}
		
	}

}
