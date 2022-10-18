package com.library.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	@Id
	int id;
	String name;
	@OneToMany
	Collection<Book> books;

}
