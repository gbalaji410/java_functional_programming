package com.balaji.fp;

import java.util.List;
import java.util.stream.Collectors;

public class FP02StreamOperation {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,7,3,5,56,7,9,11);
		
		numbers.stream()
		.sorted()  //Stream
		.forEach(System.out::println);
		
		numbers.stream()
		.distinct() //Stream 
		.forEach(System.out::println); //Terminal

	}
}