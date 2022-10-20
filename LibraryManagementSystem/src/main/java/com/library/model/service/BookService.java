package com.library.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.entity.Book;

@Service
public interface BookService {
	
	Book getBookById(int id);
	Collection<Book> getAllBooks();
	boolean addNewBook(Book book);
	boolean updateBook(Book book);
	boolean deleteBookById(int id);
	List<Book> searchBooksByType(String type);
	

}
