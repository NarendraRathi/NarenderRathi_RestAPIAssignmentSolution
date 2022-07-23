package com.greatlearning.EmployeeManagementSystemApplication.service;

import java.util.List;

import com.greatlearning.EmployeeManagementSystemApplication.entity.User;

public interface UserInterface {
	

	public List<User> findAll();
	
	public User findById(int Id);
	
	public User save(User theUser);

	public User deleteById(int theId);
	

}