package com.library.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.entity.Book;
import com.library.model.persistence.BookDao;

public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book getBookById(int id) {
		return bookDao.findById(id).orElse(null);
	}
	
	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.findAll();
	}
	
	@Override
	public boolean addNewBook(Book book) {
		//libraryDao.save(book);
		
		try {
			int rows = bookDao.insertBook(book.getBookId(), book.getType(), book.getLateFee(), book.getTotalIssued(), book.getIssuedBooks());
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
		Book b = bookDao.findById(book.getBookId()).orElse(null);
		
		if(b == null)
			return false;
		bookDao.save(book);
		return true;
	}

	@Override
	public boolean deleteBookById(int id) {
		bookDao.deleteById(id);
		return true;
	}

	@Override
	public List<Book> searchBooksByType(String type) {
		return bookDao.findByType(type);
	}

}
