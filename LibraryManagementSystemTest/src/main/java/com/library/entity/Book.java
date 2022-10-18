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
public class Book {
	@Id
	private String type;
	private double lateFee;
	@OneToMany
	private Collection<IssuedBook> issuedDates;
}
