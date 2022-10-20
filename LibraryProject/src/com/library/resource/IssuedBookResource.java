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

import com.library.entities.IssuedBook;
import com.library.service.IssuedBooksService;


@RestController
public class IssuedBookResource {
	
	@Autowired
	private IssuedBooksService issuedBookService;
	
	@PostMapping(path = "/issuedBooks",produces =MediaType.APPLICATION_JSON_VALUE)
	public Collection<IssuedBook> getBooks() {
		return issuedBookService.getAllIssuedBooks();
	}
	@PostMapping(path = "/issuedBooks/{empId}",produces =MediaType.APPLICATION_JSON_VALUE)
	public IssuedBook getEmployeeIssuedBooks(@PathVariable("empId") int id) {
		return issuedBookService.getIssuedBookById(id);
	}
	@PutMapping(path = "/issuedBooks/add")
	public Boolean addNewIssuedBook(@RequestBody IssuedBook book) {
		return issuedBookService.addNewIssuedBook(book);

	}
	@PutMapping(path = "/issuedBooks/update")
	public Boolean updateIssuedBook(@RequestBody IssuedBook book) {
		return issuedBookService.updateIssuedBook(book);

	}
	@DeleteMapping(path = "/issuedBooks/{bookId}")
	public Boolean deleteIssuedBookById(@PathVariable("bookId") int id) {
		return issuedBookService.deleteIssuedBookById(id);
	}
}
