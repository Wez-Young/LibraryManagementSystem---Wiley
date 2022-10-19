package com.library.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.library.entities.Employee;
import com.sujata.entity.User;

@Service
public interface EmployeeService {
	Collection<Employee> getEmployees();
	Employee getEmployeeById(int id);
	boolean addNewEmployee(Employee employee);
	boolean updateEmployee(Employee employee);
	boolean deleteEmployee(int id);
	Collection<Employee> getEmployeesByBookType(String booktype);
	public Employee loginEmployee(Employee employee);
	
	
}
