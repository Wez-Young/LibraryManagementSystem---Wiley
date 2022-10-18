package com.library.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entities.Book;
import com.library.entities.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
