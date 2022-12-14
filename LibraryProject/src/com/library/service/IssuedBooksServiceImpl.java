package com.library.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entities.IssuedBook;
import com.library.persistence.IssuedBookDao;

@Service
public class IssuedBooksServiceImpl implements IssuedBooksService {

	@Autowired
	private IssuedBookDao issuedBookDao;
	
	@Override
	public IssuedBook getIssuedBookById(int id) {
		return issuedBookDao.findById(id).orElse(null);
	}

	@Override
	public Collection<IssuedBook> getAllIssuedBooks() {
		return issuedBookDao.findAll();
	}

	@Override
	public boolean addNewIssuedBook(IssuedBook book) {
		try {
			int rows = issuedBookDao.insertIssuedBook(
					book.getId(), 
					book.getType(),
					book.getIssuedDate(), 
					book.getExpectedReturn(), 
					book.getActualReturn(), 
					book.getLateReturnFee()
					);
			if (rows > 0)
				return true;
			}
			catch(Exception ex) {
				return false;
			}
			return false;
	}

	@Override
	public boolean updateIssuedBook(IssuedBook book) {
		issuedBookDao.updateIssuedBook(
				book.getId(), 
				book.getType(),
				book.getIssuedDate(), 
				book.getExpectedReturn(), 
				book.getActualReturn(), 
				book.getLateReturnFee()
				);
		return true;
	}

	@Override
	public boolean deleteIssuedBookById(int id) {
		issuedBookDao.deleteById(id);
		return true;
	}

	@Override
	public List<IssuedBook> searchIssuedBooksByType(String type) {
		return issuedBookDao.findByBookType(type);
	}

}
