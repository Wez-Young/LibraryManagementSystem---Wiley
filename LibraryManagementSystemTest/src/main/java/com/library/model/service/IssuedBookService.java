package com.library.model.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.library.entity.IssuedBook;

@Service
public interface IssuedBookService {
	public Collection<IssuedBook> getAllIssuedBooks();
	public IssuedBook getIssuedBookByType();
	public IssuedBook addNewIssuedBook();
	public IssuedBook updateIssuedBook();
	public IssuedBook deleteIssuedBook();
}
