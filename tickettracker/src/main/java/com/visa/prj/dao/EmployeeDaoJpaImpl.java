package com.visa.prj.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.visa.prj.entity.Employee;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addEmployee(Employee e) {
		em.persist(e);
	}

	@Override
	public Employee getEmployeeById(String email) {
		return em.find(Employee.class, email);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return em.createQuery("from Employee", Employee.class).getResultList();
	}

}
