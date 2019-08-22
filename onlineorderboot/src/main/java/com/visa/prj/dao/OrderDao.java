package com.visa.prj.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.visa.prj.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

}
