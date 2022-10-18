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

import com.library.entities.Book;
import com.library.entities.Employee;
import com.library.service.EmployeeService;
import com.library.service.LibraryService;

@RestController
public class BookResource {
	
	@Autowired
	private LibraryService bookService;
	
	@PostMapping(path = "/books",produces =MediaType.APPLICATION_JSON_VALUE)
	public Collection<Book> getBooks() {
		return bookService.getBooks();
	}
	@PostMapping(path = "/books/{bookType}",produces =MediaType.APPLICATION_JSON_VALUE)
	public Book getBookByType(@PathVariable("bookType") String type) {
		return bookService.getBookByType(type);
	}
	@PutMapping(path = "/books/add")
	public Boolean addBook(@RequestBody Book book) {
		return bookService.addNewBook(book);
	}
	@PutMapping(path = "/books/update")
	public Boolean updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	@DeleteMapping(path = "/books/{bookType}")
	public Boolean deleteBookByType(@PathVariable("bookType") String type) {
		return bookService.deleteBook(type);
	}
}
