package com.balaji.fp;

import java.util.List;

public class FP01Exercises {

	public static void main(String[] args) {
		printEvenNumberSquaresInListFunctional(List.of(12,7,3,5,56,7,9,11));
		printEvenNumberCubesInListFunctional(List.of(12,7,3,5,56,7,9,11));

		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
		printStringValues(courses);
	}
	
	private static void printStringValues(List<String> courses) {
		
		//1. Print all values
		courses.stream()
		.forEach(System.out::println);
		
		//2. Print Courses Containing the word "Spring"
//		courses.stream()
//		.filter(course -> course.contains("Spring"))
//		.forEach(System.out::println);
		
		//3. Print Courses Whose Name has atleast 4 letters
//		courses.stream()
//		.filter(c -> c.length()>=4)
//		.forEach(System.out::println);
		
		//4. Print number of characters in each course name
		courses.stream()
		.map(course -> course + " -> " + course.length())
		.forEach(System.out::println);
		
	}

	
	private static void printEvenNumberSquaresInListFunctional(List<Integer> numbers) {
		numbers.stream()
		//.filter(FP01Programming::isEven)
		.filter(number -> number%2==0) //Lambda expression
		.map(number -> number * number) //MAPPER
		.forEach(System.out::println); //Method Reference
	}
	
	private static void printEvenNumberCubesInListFunctional(List<Integer> numbers) {
		numbers.stream()
		//.filter(FP01Programming::isEven)
		.filter(number -> number%2==0) //Lambda expression
		.map(number -> number * number * number) //MAPPER
		.forEach(System.out::println); //Method Reference
	}
	
	private static void printOddNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		//.filter(FP01Programming::isEven)
		.filter(number -> number%2==1) //Lambda expression
		.forEach(System.out::println); //Method Reference
	}

}