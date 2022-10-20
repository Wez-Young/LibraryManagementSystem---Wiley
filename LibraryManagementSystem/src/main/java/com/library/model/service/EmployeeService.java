package com.library.model.service;

import java.util.Collection;

import com.library.entity.Employee;

public interface EmployeeService {
	public Collection<Employee> getEmployees();
	public Employee getEmployeeById(int id);
	public boolean addNewEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(int id);
}
