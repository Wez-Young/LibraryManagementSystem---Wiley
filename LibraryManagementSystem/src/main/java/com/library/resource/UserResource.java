package com.library.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.User;
import com.library.model.service.UserService;

@RestController
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/login/{id}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
	public User loginResource(@PathVariable("id") int id, @PathVariable("password") String password) {
		return userService.loginUser(new User(id, password));
	}
}
