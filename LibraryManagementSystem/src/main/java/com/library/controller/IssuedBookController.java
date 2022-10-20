package com.library.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.library.entity.IssuedBook;
import com.library.model.service.IssuedBooksService;

@Controller
public class IssuedBookController {
	
	@Autowired
	private IssuedBooksService ibs;
	
	@GetMapping(path = "/",produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<IssuedBook> getEmployeeIssuedBooks(){
		return ibs.getAllIssuedBooksByEmployeeId(2);
	}
}
