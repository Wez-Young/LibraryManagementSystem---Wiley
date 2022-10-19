package com.library.resource;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.entities.Book;
import com.library.service.LibraryService;

@RestController
public class BookResource {
	
	@Autowired
	private LibraryService bookService;
	
	@PostMapping(path = "/books/{bookId}",produces =MediaType.APPLICATION_JSON_VALUE)
	public Book getBookById(@PathVariable("empId") int id) {
		return bookService.getBookById(id);
	}
	
	@PostMapping(path = "/books",produces =MediaType.APPLICATION_JSON_VALUE)
	public Collection<Book> getBooks() {
		return bookService.getAllBooks();
	}
	@PostMapping(path = "/books/types/{bookType}",produces =MediaType.APPLICATION_JSON_VALUE)
	public List<Book> getBookByType(@PathVariable("bookType") String type) {
		return bookService.searchBooksByType(type);
	}
	@PutMapping(path = "/books/add")
	public Boolean addBook(@RequestBody Book book) {
		return bookService.addNewBook(book);
	}
	@PutMapping(path = "/books/update")
	public Boolean updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	@DeleteMapping(path = "/books/delete/{bookType}")
	public Boolean deleteBookById(@PathVariable("bookType") int id) {
		return bookService.deleteBookById(id);
	}
}
