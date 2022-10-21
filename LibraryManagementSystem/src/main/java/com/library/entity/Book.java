package com.library.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	@Id @GeneratedValue
	private int bookId;
	private String type;
	private double lateFee;
	private int totalIssued;
	private int maxAmountIssued;
	
	@OneToMany
	private Collection<IssuedBook> issuedBooks;
	

}
