package edu.agh.ics.lab6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

	public static void main(String[] args) {

		Person[] persons = { new Person("Jan", "Kowalski", "1"), new Person("Andrzej", "Zima", "2"),
				new Person("Marek", "D³ugopolski", "3") };
		Comparator<Person> compA = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
		};
		Comparator<Person> compB = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().length() - o2.getLastName().length();
			}
		};
		
		Comparator<Person> compC = (pa, pb) -> pa.getFirstName().length() - pb.getFirstName().length();
		Arrays.sort(persons, compC);
		System.out.println(Arrays.toString(persons));

		ComparisonProvider comparisonProvider = new ComparisonProvider();
		Arrays.sort(persons, comparisonProvider::compareByFirstName);
		System.out.println(Arrays.toString(persons));
		Arrays.sort(persons, ComparisonProvider::compareByLastName);
		System.out.println(Arrays.toString(persons));

		List<Person> persons1 = Arrays.asList(new Person("Jan", "Kowalski", "1"), new Person("Robert", "Pec", "2"),
				new Person("Olaf", "Kowalkiewicz", "3"), new Person("Piotr", "Nowak", "4"),
				new Person("Wojciech", "Nowacki", "5"));
		Collections.sort(persons1, (pa, pb) -> pa.getLastName().length() - pb.getLastName().length());
		System.out.println(persons1);
		Collections.sort(persons1, (pa, pb) -> pb.getFirstName().length() - pa.getFirstName().length());
		System.out.println(persons1);

		ComparisonProvider comparisonProvider1 = new ComparisonProvider();
		Collections.sort(persons1, comparisonProvider1::compareByFirstName);
		System.out.println(persons1);

		persons1.forEach(System.out::println);
		persons1.forEach(p -> System.out.print(p.getFirstName() + " "));
		System.out.println(persons1.stream().filter(p -> p.getLastName().startsWith("Ko")).count());
		List<Person> ko = persons1.stream().filter(p -> p.getLastName().startsWith("Ko")).collect(Collectors.toList());
		System.out.println(ko);
		System.out.println(persons1.stream().map(p -> p.getFirstName().length()).reduce((x, y) -> x + y).get());
		System.out.println(persons1.stream().map(p -> p.getFirstName().length()).max(Integer::compareTo).get());
	}
}
