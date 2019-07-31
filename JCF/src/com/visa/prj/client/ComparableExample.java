package com.visa.prj.client;

import java.util.Arrays;

public class ComparableExample {

	public static void main(String[] args) {
		String[] names = {"Lee", "Brad", "Angelina", "George", "Kevin"};
//		Arrays.sort(names);
		Arrays.sort(names, (s1, s2) -> s1.length() - s2.length());
		
		for (String name: names) {
			System.out.println(name);
		}
	}

}
