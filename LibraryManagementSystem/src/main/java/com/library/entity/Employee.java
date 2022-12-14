package com.library.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="LibraryEmployees")
public class Employee {
	@Id @GeneratedValue
	private int id;
	private String name;
	@OneToMany
	private Collection<IssuedBook> books;
}
