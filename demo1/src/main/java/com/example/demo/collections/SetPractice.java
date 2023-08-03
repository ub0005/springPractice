package com.example.demo.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetPractice {
	
	public static void main(String[] args) {
		
		// Insertion order is not preserved
		// the order in which result returned is different from insertion
		// does not store duplicates
		
		Set hashSet = new HashSet();
		
		hashSet.add(2);
		hashSet.add(4);
		hashSet.add(1);
		hashSet.add(3);
		hashSet.add(7);
		hashSet.add(7);
		
		hashSet.stream().forEach(x -> System.out.println(x));
		
		System.out.println("Linked HashSet");
		//preserves insertion order
		//does not store duplicate values
		
		Set linkedHashset = new LinkedHashSet<>();
		
		linkedHashset.add(2);
		linkedHashset.add(4);
		linkedHashset.add(1);
		linkedHashset.add(3);
		linkedHashset.add(7);
		linkedHashset.add(7);
		
		linkedHashset.stream().forEach(x-> System.out.println(x));
		
		System.out.println("Tree Set");
		//Sorts the elements and put them in ascending order
		
		Set treeSet = new TreeSet();
		
		treeSet.add(2);
		treeSet.add(1);
		treeSet.add(4);
		treeSet.add(5);
		treeSet.add(3);
		
		treeSet.stream().forEach(x -> System.out.println(x));
		
		
		
		
	}

}
