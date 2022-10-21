package com.library.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	public User getUserByIdAndPassword(int id, String password);
}
