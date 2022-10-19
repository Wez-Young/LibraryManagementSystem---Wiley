package com.library.controllers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.library.entities.Employee;
import com.library.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/")
	public ModelAndView getLoginPage() {
		return new ModelAndView("Login","command",new Employee());
	}
	
	@RequestMapping("/loginEmployee")
	public ModelAndView loginCheck(@ModelAttribute("command") Employee employee) {
		ModelAndView modelAndView=new ModelAndView();
		Employee emp=employeeService.loginEmployee(employee);
		if(emp!=null) {
			modelAndView.addObject("employee", emp);  //request Scope
//			session.setAttribute("user", user);
			modelAndView.setViewName("Menu");
		}
		else {
			modelAndView.addObject("message", "Login Failed!");
			modelAndView.setViewName("Login");
		}
		return modelAndView;
	}

	
	@RequestMapping("/menu")
	public ModelAndView getMenuPageController() {
		return new ModelAndView("Menu");
	}

	@RequestMapping("/saveEmployeePage")
	public ModelAndView getSaveEmployeePage() {
		return new ModelAndView("InputEmployeeData", "command", new Employee());
	}

	@RequestMapping("/saveEmployee")
	public ModelAndView saveEmployeeController(@ModelAttribute("command") Employee employee) {

		ModelAndView modelAndView = new ModelAndView();

		String message = null;
		if (employeeService.addNewEmployee(employee)) {
			message = "Employee Added";
		} else
			message = "Employee Not Added";

		modelAndView.addObject("message", message);

		modelAndView.setViewName("Output");

		return modelAndView;
	}

	@RequestMapping("/searchByIdPage")
	public ModelAndView searchEmployeeByIdPageController() {
		return new ModelAndView("InputEmployeeIdForSearch","emp",new Employee());
	}

	@RequestMapping("/searchEmployee")
	public ModelAndView searchEmployeeController(@ModelAttribute("emp") Employee empl) {
		ModelAndView modelAndView = new ModelAndView();
		Employee employee = employeeService.getEmployeeById(empl.getId());

		if (employee != null) {
			modelAndView.addObject("employee", employee);
			modelAndView.setViewName("ShowEmployee");
		} else {
			modelAndView.addObject("message", "Employee with ID " + empl.getId() + " does not exist!");
			modelAndView.setViewName("Output");
		}
		return modelAndView;
	}

	@RequestMapping("/showAllEmployees")
	public ModelAndView showAllEmployeesController() {
		ModelAndView modelAndView = new ModelAndView();
		Collection<Employee> empList = employeeService.getEmployees();
		modelAndView.addObject("employees", empList);
		modelAndView.setViewName("ShowAllEmployees");

		return modelAndView;
	}
}
