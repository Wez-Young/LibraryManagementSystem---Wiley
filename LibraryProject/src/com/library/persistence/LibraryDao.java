package com.library.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.entities.Book;
import com.library.entities.IssuedBook;


@Repository
public interface LibraryDao extends JpaRepository<Book, Integer> {

	public List<Book> findByBookType(String type);
	
	@Transactional
	@Modifying
	@Query("Update Employee set bookId=:bId type=:bType, lateFee=:bLateFee, totalIssued=:bTotalIssued,  IssuedBooks=:bIssuedBooks where type=:bId")
	public int updateBook(
			@Param("bId") int bId,
			@Param("bType") String bType,
			@Param("bLateFee") double bLateFee, 
			@Param("bTotalIssued") int bTotalIssued,
			// Maybe remove
			@Param("bIssuedBooks") Collection<IssuedBook> bIssuedBooks);
	
	@Transactional
	@Modifying
	@Query(value = "insert into books values(:bookId,:type,:lateFee,:totalIssued,:issuedBooks)",nativeQuery = true)
	public int insertBook(
			@Param("bookId") int bookId,
			@Param("type") String type,
			@Param("lateFee") double lateFee,
			@Param("totalIssued") int totalIssued, 
			@Param("issuedBooks") Collection<IssuedBook> issuedBooks);

}
