package com.library.resource;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entities.Employee;
import com.library.service.EmployeeService;

@RestController
public class EmployeeResource {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping(path = "/employees",produces =MediaType.APPLICATION_JSON_VALUE)
	public Collection<Employee> getEmployees() {
		return empService.getEmployees();
	}
	@PostMapping(path = "/employees/{empId}",produces =MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable("empId") int id) {
		return empService.getEmployeeById(id);
	}
	@PutMapping(path = "/employees/add")
	public Boolean addEmployee(@RequestBody Employee employee) {
		return empService.addNewEmployee(employee);
	}
	@PutMapping(path = "/employees/update")
	public Boolean updateEmployee(@RequestBody Employee employee) {
		return empService.updateEmployee(employee);
	}
	@DeleteMapping(path = "/employees/{empId}")
	public Boolean deleteEmployeeById(@PathVariable("empId") int id) {
		return empService.deleteEmployee(id);
	}
}
