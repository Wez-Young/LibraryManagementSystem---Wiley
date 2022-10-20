package com.library.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.library.entity.Employee;
import com.library.model.persistence.EmployeeDao;

@Service
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
			int rows = employeeDao.insertEmployee(employee.getId(), employee.getName());
			if (rows > 0)
				return true;
		} catch (Exception ex) {
			return false;
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Employee emp = employeeDao.findById(employee.getId()).orElse(null);
		if (emp == null)
			return false;
		employeeDao.save(employee);
		return true;
	}

	@Override
	public boolean deleteEmployee(int id) {
		employeeDao.deleteById(id);

		return true;
	}

	@Override
	public Employee loginEmployee(Employee employee) {
		return restTemplate.getForObject("http://localhost:8084/login/" + employee.getName(), Employee.class);

	}
}