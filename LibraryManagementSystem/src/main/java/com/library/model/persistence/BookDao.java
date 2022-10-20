package com.library.model.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.Book;
import com.library.entity.IssuedBook;


@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

	public List<Book> findByType(String type);
	
	@Transactional
	@Modifying
	@Query(value = "insert into book values(:bookId,:lateFee,:totalIssued,:type)",nativeQuery = true)
	public int insertBook(
			@Param("bookId") int bookId,
			@Param("type") String type,
			@Param("lateFee") double lateFee,
			@Param("totalIssued") int totalIssued);

}
