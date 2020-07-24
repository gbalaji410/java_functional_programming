package com.balaji.fp;

import java.util.List;

public class FP01Programming {

	public static void main(String[] args) {
		printNumbersInListStructured(List.of(12,7,3,5,56,7,9,11));
		printNumbersInListFunctional(List.of(12,7,3,5,56,7,9,11));
	}
	
	private static void printNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.forEach(System.out::println); //Method Reference
	}

	private static void printNumbersInListStructured(List<Integer> numbers) {
		for(int num : numbers) {
			System.out.println(num);
		}
	}
}