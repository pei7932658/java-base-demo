package com.sy.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {

	public static void sort1() {
		List<Integer> list = Arrays.asList(1, 23, 8, 3, 6, 20, 5);

		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a.compareTo(b);
			}
		});

		for (Integer i : list) {
			System.out.println(i);
		}
	}
	
	public static void lambda(){
		List<Integer> list = Arrays.asList(1, 23, 8, 3, 6, 20, 5);
		//Collections.sort(list, (Integer a, Integer b) -> a.compareTo(b));
		Collections.sort(list, ( a,  b) -> a.compareTo(b));
		
		for (Integer i : list) {
			System.out.println(i);
		}
	}
	
	public static void createPerson(){
		PersonFactory<Person> personFactory = Person::new;
		Person person = personFactory.create("Peter", 2);
	}

	public static void main(String[] args) {
		//sort1();
		lambda();
	}
}
