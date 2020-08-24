package com.balaji.fp;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces2 {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9, 13,2,4,6,7,3,5,56,7,9,11);
		
		Predicate<Integer> isEvenPredicate = x -> x%2==0;

		Function<Integer, Integer> squareFunction = x -> x*x;
		
		Consumer<Integer> sysoutConsumer = System.out::println;
		
		
		BinaryOperator<Integer> sumOperator = Integer::sum;
		
		Supplier<Integer> randomNumbers = () -> {
			Random random = new Random();
			return random.nextInt(1000);
		};
		
		
		UnaryOperator<Integer> unaryOperator = x -> x * 3;
		
		System.out.println(unaryOperator.apply(100));
		
		//BiPredicate
		//BiFunction
		//BiConsumer
		
		BiPredicate<Integer, Integer> biPredicate = (x, y) -> x/y > 1;
		
		System.out.println(biPredicate.test(10, 2));
		
		BiFunction<Integer, Integer, Integer> biFunction = (x, y) -> x + y;
		
		System.out.println(biFunction.apply(10, 90));
		
		BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x+y);

		biConsumer.accept(99, 1);
		
		IntBinaryOperator sum = (x,y) -> x + y;
		
	}

}
