package com.library.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.entities.Book;

@Service
public interface LibraryService {
	
	Book getBookById(int id);
	Collection<Book> getAllBooks();
	boolean addNewBook(Book book);
	boolean updateBook(Book book);
	boolean deleteBookById(int id);
	List<Book> searchBooksByType(String type);
	

}
