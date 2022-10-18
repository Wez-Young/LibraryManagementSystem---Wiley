package com.library.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
	@Id
	String type;
	double lateFee;
	int totalIssued;
	
	@OneToMany
	Collection<IssuedBook> issuedBooks;
	

}
