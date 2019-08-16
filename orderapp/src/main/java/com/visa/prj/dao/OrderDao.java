package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Order;


public interface OrderDao {
	void placeOrder(Order o);
	List<Order> getOrders();
	List<Order> getOrders(Customer c);
}
