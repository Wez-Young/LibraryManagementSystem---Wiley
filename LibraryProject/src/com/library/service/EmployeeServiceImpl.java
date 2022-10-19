package com.library.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.library.entities.Employee;
import com.library.persistence.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Collection<Employee> getEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeDao.findById(id).orElse(null);
	}

	@Override
	public boolean addNewEmployee(Employee employee) {
		try {
			int rows = employeeDao.insertEmployee(employee.getId(), employee.getName(), employee.getBooks());
			if (rows > 0)
				return true;
			}
			catch(Exception ex) {
				return false;
			}
			return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee.getId(), employee.getName(), employee.getBooks());
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		employeeDao.deleteById(id);

		return true;
	}

	@Override
	public Collection<Employee> getEmployeesByBookType(String bookType) {
		return employeeDao.getEmployeesByBookType(bookType);	
	}
	
	@Override
	public Employee loginEmployee(Employee employee) {
		return restTemplate.getForObject("http://localhost:8084/login/"+employee.getId(), Employee.class);
	}

}
