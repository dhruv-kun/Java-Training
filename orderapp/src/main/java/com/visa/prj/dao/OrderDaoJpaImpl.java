package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Customer;
import com.visa.prj.entity.Order;

@Repository
public class OrderDaoJpaImpl implements OrderDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void placeOrder(Order o) {
		em.persist(o);
	}

	@Override
	public List<Order> getOrders() {
		return em.createQuery("from Order", Order.class).getResultList();
	}

	@Override
	public List<Order> getOrders(Customer c) {
		if (c == null) {
			return this.getOrders();
		} else {
			String jpql = "from Order o where o.customer = :c";
			TypedQuery<Order> query = em.createQuery(jpql, Order.class);
			query.setParameter("c", c);
			return 	query.getResultList();
		}
	}

}
