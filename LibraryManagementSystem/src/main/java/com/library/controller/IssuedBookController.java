package com.library.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.library.entity.Book;
import com.library.entity.Employee;
import com.library.entity.IssuedBook;
import com.library.entity.User;
import com.library.model.service.BookService;
import com.library.model.service.IssuedBooksService;

@Controller @Scope("session")
public class IssuedBookController {

	@Autowired
	private IssuedBooksService ibs;
	@Autowired
	private BookService bs;
	@Autowired
	private HttpSession session;

	
	@ModelAttribute("bookIds")
	List<Integer> getBookIds() {		
		User emp = (User)session.getAttribute("employee");
		
		return ibs.getAllIssuedBooksByEmployeeId(emp.getId()).stream()
				.filter(book -> book.isReturned() == false)
				.map(IssuedBook::getId)
				.collect(Collectors.toList());
	}
	
	@ModelAttribute("bookTypes")
	List<String> getBookTypes() {				
		return bs.getAllBooks().stream().map(Book::getType).collect(Collectors.toList());
	}


	@RequestMapping("/returnIssuedBookById")
	public ModelAndView getReturnBookPage() {
		if(getBookIds().size() < 1 || getBookIds() == null)
		{
			ModelAndView mv = new ModelAndView();
			mv.addObject("message", "You have no books to return");
			mv.setViewName("Menu");
			return mv;
		}
		return new ModelAndView("ReturnBookById", "command", new IssuedBook());
	}

	@RequestMapping("/returnBook")
	public ModelAndView returnBookController(@ModelAttribute("command") IssuedBook book) {
		
		ModelAndView modelAndView = new ModelAndView();
		LocalDate now = LocalDate.now();
		IssuedBook ib = ibs.getIssuedBookById(book.getId());
		String message = null;
		if (ib == null)
			message = "Error, could not find book";
		else {
			ib.setActualReturn(book.getActualReturn());
			ib.setReturned(true);
			
			Period days = Period.between(ib.getExpectedReturn(), ib.getActualReturn());
			
			if(days.getDays() > 0)
				ib.setLateReturnFee(days.getDays() * bs.searchBooksByType(ib.getType()).getLateFee());
			else
				ib.setLateReturnFee(0);
			
			if (ibs.updateIssuedBook(ib)) {
				message = "Book returned";
			} else
				message = "Error, book could not be returned";
		}

		modelAndView.addObject("message", message);

		modelAndView.setViewName("Output");

		return modelAndView;
	}
}
