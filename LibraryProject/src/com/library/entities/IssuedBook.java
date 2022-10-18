package com.library.entities;

import java.time.LocalDate;

import javax.persistence.Id;

public class IssuedBook {
	@Id
	int id;
	String type;
	LocalDate issuedDate;
	LocalDate expectedReturn;
	LocalDate actualReturn;
	double lateReturnFee;
	

}
