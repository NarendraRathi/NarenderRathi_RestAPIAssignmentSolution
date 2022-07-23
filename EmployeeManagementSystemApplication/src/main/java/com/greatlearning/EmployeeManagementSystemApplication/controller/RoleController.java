package com.greatlearning.EmployeeManagementSystemApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementSystemApplication.entity.Role;
import com.greatlearning.EmployeeManagementSystemApplication.service.RoleInterface;

@RestController
public class RoleController {

	@Autowired
	RoleInterface roleService;
//Adding roles in database
	@PostMapping("/api/roles")
	public ResponseEntity<Role> save(@RequestBody Role role) {
		try {

			return new ResponseEntity<Role>(roleService.save(role), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/api/roles")
	public List<Role> roleDetails() {
		List<Role> roles = roleService.findAll();
		return roles;
	}

}