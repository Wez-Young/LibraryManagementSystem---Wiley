package com.library.model.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.library.entity.Employee;

@Service
public interface EmployeeService {
	public Collection<Employee> getAllEmployees();
	public Employee getEmployeeById();
	public Employee addNewEmployee();
	public Employee updateEmployee();
	public Employee deleteEmployee();
}
