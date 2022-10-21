package com.library.entity;

import java.time.LocalDate;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class IssuedBook {
	@Id @GeneratedValue
	private int id;
	private String type;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate issuedDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate expectedReturn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate actualReturn;
	private double lateReturnFee;
	private boolean isReturned;
}
