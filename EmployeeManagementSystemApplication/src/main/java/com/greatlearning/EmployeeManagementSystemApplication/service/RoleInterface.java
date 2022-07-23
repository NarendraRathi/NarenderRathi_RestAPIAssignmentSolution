package com.greatlearning.EmployeeManagementSystemApplication.service;

import java.util.List;

import com.greatlearning.EmployeeManagementSystemApplication.entity.Role;

public interface RoleInterface {

	public List<Role> findAll();
	
	public Role findById(int Id);
	
	public Role save(Role theRole);

	public Role deleteById(int theId);
}