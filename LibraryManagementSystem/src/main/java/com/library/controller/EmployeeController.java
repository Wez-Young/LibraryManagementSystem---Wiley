package com.library.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.library.entity.Employee;
import com.library.entity.IssuedBook;
import com.library.entity.User;
import com.library.model.service.EmployeeService;
import com.library.model.service.IssuedBooksService;

@Controller
@Scope("session")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private IssuedBooksService ibs;
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/menu")
	public ModelAndView getMenuPageController() {
		ModelAndView modelAndView = new ModelAndView();
		User emp = (User)session.getAttribute("employee");
		if(emp != null) {
			Collection<IssuedBook> empList = ibs.getAllIssuedBooksByEmployeeId(emp.getId());
			modelAndView.addObject("books", empList);
		}
		modelAndView.setViewName("Menu");

		return modelAndView;
	}
}
