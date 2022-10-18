package com.library.model.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.library.entity.Book;

@Service
public interface BookService {
	public Collection<Book> getAllBooks();
	public Book getBookByType();
	public Book addNewBook();
	public Book updateBook();
	public Book deleteBook();
}
