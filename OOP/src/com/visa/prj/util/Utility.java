package com.visa.prj.util;

public class Utility {
	
	/*
	 * This follows OCP.
	 * Any object can be sorted as long as it has
	 * implemented the compareTo method.
	 * We don't need to change the code if any other
	 * type of object comes.
	 *
	 */
	public static void sort(Comparable[] elems) {
		for (int i = 0; i < elems.length; i++) {
			for (int j = i + 1; j < elems.length; j++) {
				if (elems[i].compareTo(elems[j]) > 0) {
					Comparable temp = elems[i];
					elems[i] = elems[j];
					elems[j] = temp;
				}
			}
		}
	}
}
