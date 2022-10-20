package com.library.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.library.entity.IssuedBook;
import com.library.model.service.EmployeeService;
import com.library.model.service.IssuedBooksService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private IssuedBooksService ibs;
	
	@RequestMapping("/")
	public ModelAndView getMenuPageController() {
		ModelAndView modelAndView = new ModelAndView();
		Collection<IssuedBook> empList = ibs.getAllIssuedBooksByEmployeeId(3);
		modelAndView.addObject("books", empList);
		modelAndView.setViewName("Menu");

		return modelAndView;
	}
	

}
