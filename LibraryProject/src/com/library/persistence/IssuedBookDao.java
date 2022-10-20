package com.library.persistence;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.entities.IssuedBook;

@Repository
public interface IssuedBookDao extends JpaRepository<IssuedBook, Integer> {
	
public List<IssuedBook> findByBookType(String type);
	
	@Transactional
	@Modifying
	@Query("Update IssuedBook set id=:bId type=:bType, issuedDate=:bIssuedDate, expectedReturn=:bexpectedReturn, actualReturn=:bactualReturn, lateReturnFee =:blateReturnFee where type=:bId")
	public int updateIssuedBook(
			@Param("bId") int bId,
			@Param("bType") String bType,
			@Param("bIssuedDate") LocalDate bIssuedDate, 
			@Param("bexpectedReturn") LocalDate bexpectedReturn,
			@Param("bactualReturn") LocalDate bactualReturn,
			@Param("blateReturnFee") double blateReturnFee);
	
	@Transactional
	@Modifying
	@Query(value = "insert into issuedBooks values(:id,:type,:issuedDate,:expectedReturn,:actualReturn,:lateReturnFee)",nativeQuery = true)
	public int insertIssuedBook(
			@Param("id") int bookId,
			@Param("type") String type,
			@Param("issuedDate") LocalDate issuedDate,
			@Param("expectedReturn") LocalDate expectedReturn, 
			@Param("actualReturn") LocalDate actualReturn,
			@Param("lateReturnFee") double lateReturnFee);

}
