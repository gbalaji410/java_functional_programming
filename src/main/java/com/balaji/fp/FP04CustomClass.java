package com.balaji.fp;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {

	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}
}

public class FP04CustomClass {

	public static void main(String[] args) {

		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("SpringBoot", "Framework", 95, 13456), new Course("API", "Microservices", 92, 18000),
				new Course("Microservices", "Microservices", 97, 22000), new Course("AWS", "Cloud", 93, 22000),
				new Course("Nodejs", "FullStack", 98, 23400), new Course("Azure", "Cloud", 99, 22200),
				new Course("Docker", "Cloud", 91, 22100), new Course("Kubernetes", "Cloud", 98, 21000));

		// allMatch, noneMatch, anyMatch
		Predicate<Course> reviewScoreMoreThan95Predicate = course -> course.getReviewScore() > 95;
		Predicate<Course> reviewScoreMoreThan90Predicate = course -> course.getReviewScore() > 90;
		Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

		System.out.println(courses.stream().allMatch(reviewScoreMoreThan95Predicate));
		System.out.println(courses.stream().noneMatch(reviewScoreMoreThan90Predicate));
		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

		System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
		System.out.println(courses.stream().anyMatch(reviewScoreMoreThan95Predicate));

		Comparator<Course> studentCountComparatorAsc = Comparator.comparingInt(Course::getNoOfStudents);

		Comparator<Course> studentCountComparatorDesc = Comparator.comparingInt(Course::getNoOfStudents).reversed();

		System.out.println(courses.stream().sorted(studentCountComparatorAsc).collect(Collectors.toList()));

		System.out.println(courses.stream().sorted(studentCountComparatorDesc).collect(Collectors.toList()));

		Comparator<Course> studentCountAndReviewsComparatorDesc = Comparator.comparingInt(Course::getNoOfStudents)
				.thenComparingInt(Course::getReviewScore).reversed();

		System.out.println(courses.stream().sorted(studentCountAndReviewsComparatorDesc).collect(Collectors.toList()));

		System.out.println(
				courses.stream().sorted(studentCountAndReviewsComparatorDesc).limit(5).collect(Collectors.toList()));

		System.out.println(courses.stream().sorted(studentCountAndReviewsComparatorDesc).skip(3).limit(3)
				.collect(Collectors.toList()));

		System.out.println(courses);

		// Print the entries until the predicate is TRUE
		System.out.println(
				courses.stream().takeWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));

		// Drop/Skip the entries until the predicate is TRUE
		System.out.println(
				courses.stream().dropWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));

		Optional<Course> max = courses.stream().max(studentCountAndReviewsComparatorDesc);

		System.out.println(max.get());

		Course min = courses.stream().min(studentCountAndReviewsComparatorDesc)
				.orElse(new Course("AdvancedJava", "Programming", 98, 21000));

		System.out.println(min);

		System.out.println(
				courses.stream().filter(reviewScoreLessThan90Predicate).min(studentCountAndReviewsComparatorDesc)
						.orElse(new Course("AdvancedJava", "Programming", 98, 21000)));

		System.out.println(courses.stream().filter(reviewScoreLessThan90Predicate).findFirst());// Optional.empty

		System.out.println(courses.stream().filter(reviewScoreMoreThan95Predicate).findFirst());

		System.out.println(courses.stream().filter(reviewScoreMoreThan95Predicate).findAny());

		// Few more operations
		// Total students in all courses with > 95 reviews
		System.out.println(
				courses.stream().filter(reviewScoreMoreThan95Predicate).mapToInt(Course::getNoOfStudents).sum());

		// Average # of students in all courses with > 95 reviews
		System.out.println(
				courses.stream().filter(reviewScoreMoreThan95Predicate).mapToInt(Course::getNoOfStudents).average()); // OptionalDouble

		System.out.println(
				courses.stream().filter(reviewScoreMoreThan95Predicate).mapToInt(Course::getNoOfStudents).count()); // Count

		System.out.println(
				courses.stream().filter(reviewScoreMoreThan95Predicate).mapToInt(Course::getNoOfStudents).max());

		System.out.println(
				courses.stream().filter(reviewScoreMoreThan95Predicate).mapToInt(Course::getNoOfStudents).min());

		// Grouping of Courses into a Hashmap. Key = Category, Value = List of Courses
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
		
		
		// Grouping of Courses into a Hashmap. Key = Category, Value = Count of Courses
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		
		// Grouping of Courses into a Hashmap. Key = Category, Value = Courses with highest reviews in this category
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, 
				Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		
		
		// Grouping of Courses into a Hashmap. Key = Category, Value = Names of Courses
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, 
				Collectors.mapping(Course::getName, Collectors.toList()))));


	}

}
