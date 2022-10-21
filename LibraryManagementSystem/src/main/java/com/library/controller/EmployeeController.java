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
	
	@RequestMapping("/menu")
	public ModelAndView getMenuPageController(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User emp = (User)session.getAttribute("employee");
		Collection<IssuedBook> books =  ibs.getAllIssuedBooksByEmployeeId(emp.getId());
		if(books != null) {
			System.out.println("Books size " +books.size());
			modelAndView.addObject("books", books);
			session.setAttribute("books", books);
		}
		else {
			modelAndView.addObject("message", "You have no books currently issued");
		}
		modelAndView.setViewName("Menu");

		return modelAndView;
	}
}
