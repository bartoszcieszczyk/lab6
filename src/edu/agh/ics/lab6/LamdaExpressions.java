package edu.agh.ics.lab6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LamdaExpressions {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(new Person("Bartosz", "Ciêszczyk", "1"), new Person("Sylwester", "Moska³a", "2"), new Person("Joanna", "Jurczyk", "3"), new Person("Magdalena", "Ciêszczyk", "4"));
		
		Comparator<Person> compA = (pa, pb) -> pa.getFirstName().length() - pb.getFirstName().length();
		
		Collections.sort(persons, compA);
		
		System.out.println(persons);
		
		Person[] persons1 = { new Person("Julka", "Siwek", "1"), new Person("Agnieszka", "Leonowicz", "2"), new Person("Przemys³aw", "Zawadzki", "3"), new Person("Grzegorz", "Paulewicz", "4"), new Person("Kacper", "Witek", "5") };
		
		Arrays.sort(persons1, (pa, pb) -> pa.getLastName().length() - pb.getLastName().length());
		
		System.out.println(Arrays.toString(persons1));
		
		persons.forEach(System.out::println);
		
		persons.forEach((p) -> System.out.print(p.getPesel() + " "));
		
		System.out.println();
		
		System.out.println(persons.stream().filter(p -> p.getLastName().endsWith("czyk")).count());
		
		List<Person> ko = persons.stream().filter(p -> p.getLastName().contains("s")).collect(Collectors.toList());

		System.out.println(ko);
		
		
	}

}
