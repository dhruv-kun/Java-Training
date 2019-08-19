package com.visa.prj.dao;

import java.util.List;

import com.visa.prj.entity.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee e);
	public Employee getEmployeeById(String email);
	public List<Employee> getAllEmployees();
}
