package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PrintHashMap {
	
	public static void main(String[] args) {
		 
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("Telangana", "Hyderabad");
		map.put("Karnataka","Bangalore");
		map.put("Kerala", "Tiruvananthapuram");
		map.put("Maharastra", "Mumbai");
		
		//map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey() + " "+ entry.getValue()));
		
		Map<String, String> treeMap = new TreeMap<>();
		treeMap.putAll(map);
		
		treeMap.entrySet().stream().forEach(x -> System.out.println(x));
	}

}
