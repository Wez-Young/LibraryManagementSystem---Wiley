package com.library.model.service;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.library.entity.IssuedBook;

@Service
public interface IssuedBooksService {
	
	IssuedBook getIssuedBookById(int id);
	Collection<IssuedBook> getAllIssuedBooks();
	Collection<IssuedBook> getAllIssuedBooksByEmployeeId(int id);
	boolean addNewIssuedBook(IssuedBook book);
	boolean updateIssuedBook(IssuedBook book);
	boolean deleteIssuedBookById(int id);
	List<IssuedBook> searchIssuedBooksByType(String type);
	public boolean addIssuedBookToRelationship(IssuedBook book, HttpSession session);

}
