package com.visa.prj.client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.visa.prj.entity.Product;

public class ListExample {

	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product(645,"HP Laptop",135000.00,"computer",100));
		products.add(new Product(224,"iPhone",98000.00,"mobile",500));
		products.add(new Product(834,"Logitech Mouse",600.00,"computer",300));
		products.add(new Product(5,"Sony Bravia",125000.00,"tv",900));
		products.add(new Product(912,"One Plus",32000.00,"mobile",100));
		products.add(new Product(88,"HP Printer",19000.00,"computer",100));
		
//		products.stream().filter(p -> p.getCategory().equals("mobile")).forEach(p -> System.out.println(p));
		
		List<String> names = products.stream().filter(p -> p.getCategory().equals("mobile")).map(p -> p.getName()).collect(Collectors.toList());
		for (String name: names)
			System.out.println(name);
		
		double total = products.stream().map(p -> p.getPrice()).reduce(0.0, (v1, v2) -> v1 + v2);
		System.out.println(total);
		
		
		// Method reference is a shortcut to lambdas
		products.stream().map(p -> p.getName()).forEach(System.out::println);
		
		double maxValue = products.stream().map(p -> p.getPrice()).reduce(0.0, Math::max);
		
		System.out.println(maxValue);
		
//		Collections.sort(products, (p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
//		
//		/*
//		 * Use the below 2 as they lock the collections
//		 * for further modifications by acquiring the lock.
//		 */
//		System.out.println("For Each Loop");
//		for (Product p: products) {
//			System.out.println(p);
//		}
//		
//		/*
//		 * Use this when want to modify the collection 
//		 * based on conditions
//		 */
//		System.out.println("Iterator");
//		Iterator<Product> iter = products.iterator();
//		while (iter.hasNext()) {
//			Product p = iter.next();
//			System.out.println(p);
//		}
//		
//		/*
//		 * Don't use this
//		 */
//		System.out.println("Index Based");
//		for (int i = 0; i < products.size(); i++) {
//			System.out.println(products.get(i));
//		}
	}

}
