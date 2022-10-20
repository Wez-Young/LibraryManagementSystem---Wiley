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
	@Query(value = "insert into issuedBook values(:id,:actualReturn,:expectedReturn,:issuedDate,:lateReturnFee, :type)",nativeQuery = true)
	public int insertIssuedBook(
			@Param("id") int bookId,
			@Param("type") String type,
			@Param("issuedDate") LocalDate issuedDate,
			@Param("expectedReturn") LocalDate expectedReturn, 
			@Param("actualReturn") LocalDate actualReturn,
			@Param("lateReturnFee") double lateReturnFee);
	
	@Query("SELECT book FROM libraryemployees_books i WHERE id = :empId ")
	Collection<IssuedBook> findAllLibraryEmployeesIssuedBooks(@Param("empId") int id);


}
