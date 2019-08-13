package com.visa.prj.dao;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Product;

@Repository
@Profile("dev")
public class ProductDaoTestImpl implements ProductDao {

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addProduct(Product p) {
		System.out.println("Prduct Development Saved!!");
		return 0;
	}

}
