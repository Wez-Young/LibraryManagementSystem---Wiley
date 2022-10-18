package com.library.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entities.Book;

public interface LibraryDao extends JpaRepository<Book, Integer> {

}
