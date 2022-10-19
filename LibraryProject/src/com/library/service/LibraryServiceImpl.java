package com.library.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.entities.Book;
import com.library.persistence.LibraryDao;

public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryDao libraryDao;
	
	@Override
	public Book getBookById(int id) {
		return libraryDao.findById(id).orElse(null);
	}
	
	@Override
	public Collection<Book> getAllBooks() {
		return libraryDao.findAll();
	}
	
	@Override
	public boolean addNewBook(Book book) {
		//libraryDao.save(book);
		
		try {
			int rows = libraryDao.insertBook(book.getType(), book.getLateFee(), book.getTotalIssued(), book.getIssuedBooks());
			if (rows > 0)
				return true;
			}
			catch(Exception ex) {
				return false;
			}
			return false;
	}

	@Override
	public boolean updateBook(Book book) {	
		libraryDao.updateBook(book.getType(), book.getLateFee(), book.getTotalIssued(), book.getIssuedBooks());
		return true;
	}

	@Override
	public boolean deleteBookById(int id) {
		libraryDao.deleteById(id);
		return true;
	}

	@Override
	public List<Book> searchBooksByType(String type) {
		return libraryDao.findByBookType(type);
	}

}
