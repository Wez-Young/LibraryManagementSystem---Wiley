package com.library.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class IssuedBook {
	@Id
	private int Id;
	private LocalDateTime issuedDate;
	private LocalDateTime expectedReturnDate;
	private LocalDateTime actualReturnDate;
	private double incurredLateFee;
}
