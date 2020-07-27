package com.balaji.fp;

import java.util.List;
import java.util.stream.Collectors;

public class FP02Programming {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,7,3,5,56,7,9,11);
		int sum = addListFunctional(numbers);
		System.out.println(sum);
		
		List<Integer> doubledNumbers = doubledList(numbers);
		doubledNumbers.stream().forEach(System.out::println);
		
		
		List<Integer> evenNumbers = evenNumbersList(numbers);
		evenNumbers.stream().forEach(System.out::println);
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes");
		List<String> courseLengths = courseLengths(courses);
		courseLengths.stream().forEach(System.out::println);
	}

	private static List<String> courseLengths(List<String> courses) {
		return courses.stream()
				.map(x-> x + " -> " + x.length())
				.collect(Collectors.toList());
	}

	private static List<Integer> evenNumbersList(List<Integer> numbers) {
		return numbers.stream()
				.filter(x -> x%2==0)
				.collect(Collectors.toList());
	}

	private static List<Integer> doubledList(List<Integer> numbers) {
		return numbers.stream()
		.map(x -> x*x)
		.collect(Collectors.toList());
	}

	private static int sum(int aggregate, int nextNumber) {
		System.out.println(aggregate+","+nextNumber);
		return aggregate + nextNumber;
	}
	private static int addListFunctional(List<Integer> numbers) {
		return numbers.stream()
		//.reduce(0, FP02Programming::sum);
				.reduce(0, Integer::sum);
	}

}