package com.library.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.library.entities.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Collection<Employee> getEmployees() {
		return 
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Employee> getEmployeesByBookType(String booktype) {
		// TODO Auto-generated method stub
		return null;
	}

}
