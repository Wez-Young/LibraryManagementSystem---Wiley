package com.library.model.persistence;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.IssuedBook;

@Repository
public interface IssuedBookDao extends JpaRepository<IssuedBook, Integer> {
	
public List<IssuedBook> findByType(String type);
	
	@Transactional
	@Modifying
	@Query(value = "insert into issuedBook values(:id, :actualReturn,:expectedReturn,:issuedDate,:lateReturnFee, :type, :isReturned)",nativeQuery = true)
	public int insertIssuedBook(
			@Param("id") int bookId,
			@Param("type") String type,
			@Param("issuedDate") LocalDate issuedDate,
			@Param("expectedReturn") LocalDate expectedReturn, 
			@Param("actualReturn") LocalDate actualReturn,
			@Param("lateReturnFee") double lateReturnFee,
			@Param("isReturned") boolean isReturned);
	
	@Query(value = "SELECT id, actualReturn, expectedReturn, issuedDate, lateReturnFee, type, isReturned FROM IssuedBook i inner join libraryemployees_books e WHERE e.employee_id = :empId and id = :empId", nativeQuery = true)
	Collection<IssuedBook> findAllLibraryEmployeesIssuedBooks(@Param("empId") int id);
	
	@Transactional
	@Modifying
	@Query(value = "insert into libraryemployees_books values(:employee_id,:books_id)",nativeQuery = true)
	public int insertIssuedBookInRelationship(
			@Param("employee_id") int id,
			@Param("books_id") int b_id);
	
	@Query(value = "select * from issuedbook where id in (select books_id from libraryemployees_books l where l.Employee_id = :empId)", nativeQuery = true)
	Collection<IssuedBook> findAllIssuedBooksInRelation(@Param("empId") int id);
	

}
