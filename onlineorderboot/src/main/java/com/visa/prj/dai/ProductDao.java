package com.visa.prj.dai;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
