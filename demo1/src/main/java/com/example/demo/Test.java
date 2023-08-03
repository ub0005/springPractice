package com.example.demo;

import java.util.Optional;

public class Test {

	public static void main(String[] args) {
	
//		Test test1 = new Test();
//		test1.add(4, 5);
//		BiConsumer<Integer, Integer> biConsumer = (a,b) -> System.out.println(a+b);
//		// biConsumer.accept(5, 8);
//		
//		Predicate<String> predicate = s -> s.length() >=5;
//		//System.out.println(predicate.test("Uday kumar bommala"));
//		
//		Function <Integer, Integer> function = i -> i*i;
//		
//		//System.out.println(function.apply(5));
//		
//		List<Integer> arList = new ArrayList<Integer>();
//		arList.add(19);
//		arList.add(23);
//		arList.add(56);
//		arList.add(35);
//		
//		
//		arList.add(0, 243);
//		
//		
//		List<Integer> newArList = arList.stream().filter(i -> i > 30).collect(Collectors.toList());
//		
//		//newArList.forEach(x -> System.out.println(x));
//		
//		arList.stream().map(i->i*i).forEach(i-> System.out.println(i));
		Optional<String> optionalValue = Optional.of("Hello, World!");

        // Retrieving the value from the Optional
        String value = optionalValue.get();
        System.out.println(value); 
	}
	
//	public void add(Integer a, Integer b) {
//		System.out.println(a+b);
//	}
}
