package com.library.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Book {
	@Id
	String type;
	double lateFee;
	int totalIssued;
	
	@OneToMany
	Collection<IssuedBook> issuedBooks;
	

}
