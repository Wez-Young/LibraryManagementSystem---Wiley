package com.library.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.entities.IssuedBook;

@Service
public interface IssuedBooksService {
	
	IssuedBook getIssuedBookById(int id);
	Collection<IssuedBook> getAllIssuedBooks();
	boolean addNewIssuedBook(IssuedBook book);
	boolean updateIssuedBook(IssuedBook book);
	boolean deleteIssuedBookById(int id);
	List<IssuedBook> searchIssuedBooksByType(String type);

}
