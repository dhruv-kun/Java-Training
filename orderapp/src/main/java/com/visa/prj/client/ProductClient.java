package com.visa.prj.client;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.entity.Product;
import com.visa.prj.service.OrderService;

public class ProductClient {

	public static void main(String[] args) {
		// create spring container
		// Annotations based
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		
		// XML based
		// ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml");
		
		ctx.scan("com.visa.prj");
		ctx.refresh();
		
		// spring creates ids by lower-casing the first letter of class
		OrderService os = ctx.getBean("orderService", OrderService.class);
		
//		Product p = new Product(0, "Realme 7", "mobile", 12999.00, 1000);
//		os.insertProduct(p);
//		System.out.println("Inserted: " + p.getId());
//		
//		p = os.getById(p.getId());
//		System.out.println(p.getName() + "," + p.getCategory() + "," + p.getPrice());
		
		List<Product> pList = os.fetchProducts();
		for (Product p: pList)
			System.out.println(p.getName() + "," + p.getCategory() + "," + p.getPrice());
		
	}
}
