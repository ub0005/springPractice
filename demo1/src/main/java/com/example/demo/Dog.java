package com.example.demo;

public class Dog {
	
	String color;
	String name;
	String breed;
	
	public Dog(String color, String name, String breed) {
		this.color = color;
		this.name = name;
		this.breed = breed;
	}
	public Dog() {
		
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public void printColor() {
		System.out.println("Color of the dog is " + color);
	}
	
	

}
