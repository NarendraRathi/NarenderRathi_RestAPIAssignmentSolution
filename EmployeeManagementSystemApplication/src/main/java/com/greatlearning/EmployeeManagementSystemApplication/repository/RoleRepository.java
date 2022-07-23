package com.greatlearning.EmployeeManagementSystemApplication.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.EmployeeManagementSystemApplication.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}