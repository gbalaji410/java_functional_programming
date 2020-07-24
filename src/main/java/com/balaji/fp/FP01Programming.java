package com.balaji.fp;

import java.util.List;

public class FP01Programming {

	public static void main(String[] args) {
		printNumbersInListFunctional(List.of(12,7,3,5,56,7,9,11));
		printEvenNumbersInListStructured(List.of(12,7,3,5,56,7,9,11));
	}

	@SuppressWarnings("unused")
	private static void printNumbersInListFunctional(List<Integer> numbers) {
		numbers.stream()
		.forEach(System.out::println); //Method Reference
	}

	@SuppressWarnings("unused")
	private static void printNumbersInListStructured(List<Integer> numbers) {
		for(int num : numbers) {
			System.out.println(num);
		}
	}
	
	private static void printEvenNumbersInListStructured(List<Integer> numbers) {
		for(int num : numbers) {
			if(num%2==0)
				System.out.println(num);
		}
	}
}