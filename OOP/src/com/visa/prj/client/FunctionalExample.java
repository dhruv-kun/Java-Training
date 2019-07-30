package com.visa.prj.client;


@FunctionalInterface
interface Computation {
	int compute(int x, int y);
}

public class FunctionalExample {

	public static void main(String[] args) {
		
		/*
		 * Decreasing lines of code for same operations
		 * using functional interface, anonymous class
		 * and lambdas.
		 */
		
		// Anonymous Class implementations
		Computation c1 = new Computation() {
			public int compute(int x, int y) {
				return x + y;
			};
		};
		doTask(c1, 3, 4);
		
		Computation c2 = new Computation() {
			public int compute(int x, int y) {
				return x - y;
			};
		};
		doTask(c2, 3, 4);
		
		
		/* 
		 * Lambdas for which functional interface is 
		 * needed.
		 */
		Computation c3 = (int x, int y) -> {
			return x * y;
		};
		doTask(c3, 3, 4);
		
		Computation c4 = (x, y) -> {
			return x / y;
		};
		doTask(c4, 3, 4);
		
		Computation c5 = (x, y) -> x & y;
		doTask(c5, 3, 4);
		
	}

	private static void doTask(Computation c1, int i, int j) {
		System.out.println(c1.compute(i, j));
	}

}
