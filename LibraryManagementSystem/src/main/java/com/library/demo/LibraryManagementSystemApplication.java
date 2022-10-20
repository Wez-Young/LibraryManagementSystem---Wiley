package com.library.demo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.library.entity.Book;
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
		
	}

}
