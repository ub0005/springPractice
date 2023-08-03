package com.example.demo.collections;

import java.util.TreeMap;

public class HashMapCollection {
	
	public static void main(String[] args) {
		
		// stores values in key value pairs
		// entry set gives both key and values
		// does allow only one null key but allows multiple null values
		// does not preserve insertion order
//		HashMap<String, Integer> map = new HashMap<String, Integer>();
//		
//		map.put("Uday", 34);
//		map.put("charan", 23);
//		map.put("Sai", 21);
//		
//		map.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " "+ x.getValue()));
//		
//		System.out.println("Linked Hash Map");
//		// Preserve insertion order
//		LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<String, Integer>();
//		
//		linkedHashMap.put("Uday", 34);
//		linkedHashMap.put("charan", 23);
//		linkedHashMap.put("Sai", 21);
//		
//		linkedHashMap.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " "+ x.getValue()));
//		
//		
//		System.out.println("Tree Map");
		
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		
		treeMap.put(34, "apple");
		treeMap.put(44, "Uday");
		treeMap.put(53, "charan");
		treeMap.put(30, "bananas");
		treeMap.put(41, "Sai");
		
		treeMap.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " "+ x.getValue()));
		
	}

}
