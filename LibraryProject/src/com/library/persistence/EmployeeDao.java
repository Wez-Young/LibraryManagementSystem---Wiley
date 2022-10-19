package com.library.persistence;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.library.entities.Book;
import com.library.entities.Employee;
import com.library.entities.IssuedBook;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
	
	
	@Transactional
	@Modifying
	@Query("Update Employee set id=:eId, name=:eName, books=:issBooks where id=:eId")
	public int updateEmployee(@Param("eId") int eId,@Param("eName") String eName, @Param("issBooks") Collection<IssuedBook> books);
	
	@Transactional
	@Modifying
	@Query(value = "insert into employee values(:id,:name,:books)",nativeQuery = true)
	public int insertEmployee(@Param("id") int id,@Param("name") String name, @Param("books") Collection<IssuedBook> books);
	
	
	@Transactional
	@Modifying
	@Query(value = "SELECT e.id, e.name FROM employee e WHERE ARRAY_CONTAINS(e.books,{'type': :bookType}, true)")
	public Collection<Employee> getEmployeesByBookType(@Param("bookType") String bookType);
	
	/*
	 * possible left join employees with issued 
	 */
	

}
