package com.visa.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.prj.dao.ProductDao;
import com.visa.prj.entity.Product;

@Service
public class OrderService {

	@Autowired(required=false)
	private ProductDao productDao;

	@Transactional
	public int insertProduct(Product p) {
		return productDao.addProduct(p);
	}

	public List<Product> fetchProducts() {
		return productDao.getProducts();
	}

	public Product getById(int id) {
		return productDao.getProduct(id);
	}
}
