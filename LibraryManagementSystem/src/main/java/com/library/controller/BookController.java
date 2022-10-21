package com.library.controller;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.library.entity.Book;
import com.library.entity.IssuedBook;
import com.library.model.service.BookService;
import com.library.model.service.IssuedBooksService;

@Controller @Scope("session")
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private IssuedBooksService ibs;
	
	@ModelAttribute("library")
	List<Book> getBooks() {				
		return bookService.getAllBooks().stream().collect(Collectors.toList());
	}
	
	@ModelAttribute("bookTypes")
	List<String> getBookTypes() {				
		return bookService.getAllBooks().stream().map(Book::getType).collect(Collectors.toList());
	}
	
	@RequestMapping("/issueNewBook")
	public ModelAndView getIssueBookPageController(@ModelAttribute("command") IssuedBook book) {
		return new ModelAndView("IssueNewBook", "command", new IssuedBook());
	}
	@RequestMapping("/bookIssued")
	public ModelAndView issueBook(@ModelAttribute("command") IssuedBook book, HttpSession  session) {
		Book updateBook = bookService.searchBooksByType(book.getType());
		ModelAndView modelAndView = new ModelAndView();
		
		if(updateBook.getTotalIssued() + 1 < updateBook.getMaxAmountIssued()) {
			updateBook.setTotalIssued(updateBook.getTotalIssued()+1);
			bookService.updateBook(updateBook);

			book.setId(1);
			book.setExpectedReturn(book.getIssuedDate().plusDays(7));
			book.setReturned(false);
			
			if(LocalDate.now().isAfter(book.getIssuedDate())) {
				modelAndView.addObject("message", "Issue date cannot be before: " + LocalDate.now());
				modelAndView.setViewName("IssueNewBook");
				return modelAndView;
			}
			
			if(ibs.addNewIssuedBook(book) && ibs.addIssuedBookToRelationship(book, session))
				modelAndView.addObject("message", "Book issued");
			else {
				modelAndView.addObject("message", "Book not issued correctly");
				ibs.deleteIssuedBookById(book.getId());
			}
		}else {
			modelAndView.addObject("message", "You cannot issue any more of this book at this moment in time!");
			modelAndView.setViewName("IssueNewBook");
			return modelAndView;
		}
			
		
		modelAndView.setViewName("Output");

		return modelAndView;
	}
}
