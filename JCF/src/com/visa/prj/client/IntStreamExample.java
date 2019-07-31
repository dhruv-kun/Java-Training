package com.visa.prj.client;

import java.util.stream.IntStream;

public class IntStreamExample {

	public static void main(String[] args) {
		long sum = IntStream.range(1, 100).sum();
		System.out.println(sum);
	}

}
