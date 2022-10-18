package com.library.entity;

import java.util.Collection;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {

	@Id
	private int Id;
	private String name;
	@OneToMany
	private Collection<Book> issuedBooks;
}
