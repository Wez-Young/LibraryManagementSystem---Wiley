package com.library.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjusters;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.library.entity.Book;
import com.library.entity.Employee;
import com.library.entity.IssuedBook;
import com.library.model.service.BookService;
import com.library.model.service.EmployeeService;
import com.library.model.service.IssuedBooksService;

@SpringBootApplication(scanBasePackages = "com.library")
@EntityScan(basePackages = "com.library.entity")
@EnableJpaRepositories(basePackages = "com.library.model.persistence")
public class LibraryManagementSystemApplication implements CommandLineRunner{
	@Autowired
	EmployeeService empService;
	@Autowired
	BookService bookService;
	@Autowired
	IssuedBooksService issuedBookService;
	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Collection<IssuedBook> ib = null;
		LocalDate date = LocalDate.now();
		
		bookService.addNewBook(new Book(1, "Data Analytics", 5, 0, ib));
		bookService.addNewBook(new Book(2, "Technology", 6, 0, ib));
		bookService.addNewBook(new Book(3, "Management", 7, 0, ib));
		
		empService.addNewEmployee(new Employee(1, "Wez", ib));
		empService.addNewEmployee(new Employee(2, "Sam", ib));
		empService.addNewEmployee(new Employee(3, "Jamie", ib));
		empService.addNewEmployee(new Employee(4, "Sergiu", ib));
		
		issuedBookService.addNewIssuedBook(new IssuedBook(1, "Data Analytics", date, date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)), null, 0));
		issuedBookService.addNewIssuedBook(new IssuedBook(2, "Technology", date, date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)), null, 0));
		issuedBookService.addNewIssuedBook(new IssuedBook(3, "Data Analytics", date, date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)), null, 0));
		issuedBookService.addNewIssuedBook(new IssuedBook(4, "Technology", date, date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)), null, 0));
		issuedBookService.addNewIssuedBook(new IssuedBook(5, "Management", date, date.with(TemporalAdjusters.next(DayOfWeek.THURSDAY)), null, 0));
	}

}
