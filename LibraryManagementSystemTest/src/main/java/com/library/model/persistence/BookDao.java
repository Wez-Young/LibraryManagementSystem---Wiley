package com.library.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.Employee;

public interface BookDao extends JpaRepository<Employee, Integer>{

}
