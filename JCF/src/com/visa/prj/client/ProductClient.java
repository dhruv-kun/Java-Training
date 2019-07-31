package com.visa.prj.client;

import java.util.Arrays;

import com.visa.prj.entity.Product;

public class ProductClient {

	public static void main(String[] args) {
		Product[] products = new Product[6];
		products[0] = new Product(645,"HP Laptop",135000.00,"computer",100);
		products[1] = new Product(224,"iPhone",98000.00,"mobile",500);
		products[2] = new Product(834,"Logitech Mouse",600.00,"computer",300);
		products[3] = new Product(5,"Sony Bravia",125000.00,"tv",900);
		products[4] = new Product(912,"One Plus",32000.00,"mobile",100);
		products[5] = new Product(88,"HP Printer",19000.00,"computer",100);
		
		Arrays.sort(products, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
		
		for (Product p: products)
			System.out.println(p.getName());

	}

}
