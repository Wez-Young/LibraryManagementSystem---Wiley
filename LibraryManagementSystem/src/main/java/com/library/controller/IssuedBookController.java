package com.library.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.library.entity.IssuedBook;
import com.library.model.service.IssuedBooksService;

@Controller
public class IssuedBookController {
	
	@Autowired
	private IssuedBooksService ibs;
	
	@GetMapping(path = "/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView getEmployeeIssuedBooks(){
		ModelAndView modelAndView = new ModelAndView();
		Collection<IssuedBook> empList = ibs.getAllIssuedBooksByEmployeeId(1);
		System.out.println(empList.size());
		modelAndView.addObject("books", empList);
		modelAndView.setViewName("Menu");

		return modelAndView;
	}
}
