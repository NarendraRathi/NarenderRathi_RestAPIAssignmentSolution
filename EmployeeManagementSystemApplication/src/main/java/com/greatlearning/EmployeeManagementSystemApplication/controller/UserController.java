package com.greatlearning.EmployeeManagementSystemApplication.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementSystemApplication.entity.User;
import com.greatlearning.EmployeeManagementSystemApplication.service.UserInterface;

@RestController
public class UserController {

	@Autowired
	UserInterface userService;
//Adding users in database used for authentication purpose
	@PostMapping("/api/users")
	public ResponseEntity<User> save(@RequestBody User user) {
		try {

			return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/api/users")
	public List<User> userDetails() {
		List<User> users = userService.findAll();
		return users;
	}
}