package com.balaji.fp;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviorParameterization {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9, 13,2,4,6,7,3,5,56,7,9,11);
		
		//Passing code of the method/algorithm/Strategy as argument
		
		//filterAndPrint(numbers, x -> x%2 == 0);
		
		//filterAndPrint(numbers, x -> x%2 != 0);
		
		filterAndPrint(numbers, x -> x%3 == 0);
		
		List<Integer> squares = mapAndCreateList(numbers, x -> x*x*x);
		
		System.out.println(squares);
		
	}

	private static List<Integer> mapAndCreateList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
		return numbers.stream()
		.map(mappingFunction)
		.collect(Collectors.toList());
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}

}
