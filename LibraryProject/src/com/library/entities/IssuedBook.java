package com.library.entities;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IssuedBook {
	@Id
	int id;
	String type;
	LocalDate issuedDate;
	LocalDate expectedReturn;
	LocalDate actualReturn;
	double lateReturnFee;
	

}
