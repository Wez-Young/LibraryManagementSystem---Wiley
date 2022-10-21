package com.library.model.service;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.IssuedBook;
import com.library.entity.User;
import com.library.model.persistence.IssuedBookDao;

@Service
public class IssuedBooksServiceImpl implements IssuedBooksService {

	@Autowired
	private IssuedBookDao issuedBookDao;
	@Autowired
	private HttpSession session;
	
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
					book.getLateReturnFee(),
					book.isReturned()
					);
			if (rows > 0)
				return true;
			}
			catch(Exception ex) {
				return false;
			}
			return false;
	}
	
	public boolean addIssuedBook(IssuedBook book, HttpSession session) {
		User usr = (User)session.getAttribute("employee");
		try {
			int rows = issuedBookDao.insertIssuedBookInRelationship(
					usr.getId(),
					book.getId() 
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
		IssuedBook ib = issuedBookDao.findById(book.getId()).orElse(null);
		
		if(ib == null)
			return false;
		issuedBookDao.save(book);
		return true;
	}

	@Override
	public boolean deleteIssuedBookById(int id) {
		issuedBookDao.deleteById(id);
		return true;
	}

	@Override
	public List<IssuedBook> searchIssuedBooksByType(String type) {
		return issuedBookDao.findByType(type);
	}

	@Override
	public Collection<IssuedBook> getAllIssuedBooksByEmployeeId(int id) {
		return issuedBookDao.findAllLibraryEmployeesIssuedBooks(id);
	}

}
