package com.library.controller;

import java.util.Collection;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.library.entity.IssuedBook;
import com.library.entity.User;
import com.library.model.service.IssuedBooksService;

@Controller
@Scope("session")
public class EmployeeController {
	@Autowired
	private IssuedBooksService ibs;
	@Autowired
	private HttpSession session;
	
	@ModelAttribute("books")
	Collection<IssuedBook> getIssuedBooks() {	
		User emp = (User)session.getAttribute("employee");
		return ibs.getAllIssuedBooksByEmployeeId(emp.getId());
	}
	
	@RequestMapping("/menu")
	public ModelAndView getMenuPageController() {
		ModelAndView modelAndView = new ModelAndView();
		if(getIssuedBooks() != null) {
		modelAndView.addObject("books", getIssuedBooks());
		}
		else {
			modelAndView.addObject("message", "You have no books currently issued");
		}
		modelAndView.setViewName("Menu");

		return modelAndView;
	}
}
