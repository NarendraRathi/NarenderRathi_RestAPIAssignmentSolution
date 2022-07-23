package com.greatlearning.EmployeeManagementSystemApplication.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.EmployeeManagementSystemApplication.entity.Employee;
import com.greatlearning.EmployeeManagementSystemApplication.repository.EmployeeRepository;
import com.greatlearning.EmployeeManagementSystemApplication.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;
// list all employees stored in database
	@GetMapping(value = "/api/employees")
	public List<Employee> employeeDetails() {
		List<Employee> employees = employeeService.findAll();
		return employees;
	}
// list employee by their id
	@GetMapping(value = "/api/employees/{id}")
	public ResponseEntity<Employee> employeeDetail(@PathVariable int id) {
		try {
			return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
// list employees by custom sorting by name
	@GetMapping(value = "/api/employees/sort")
	public List<Employee> sortEmployeeDetails(Direction direction) {
		List<Employee> employees = employeeRepository.findAll(Sort.by(direction, "firstName" ));
		return employees;
		

	}
// list employee by their first name
	@GetMapping(value = "/api/employees/search/{firstName}")
	public ResponseEntity<List<Employee>> employeeDetailOnFirstName(@PathVariable String firstName) {
		try {
			return new ResponseEntity<>(employeeService.findByFirstName(firstName), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
// Add employee in database
	@PostMapping("/api/employees")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		try {

			return new ResponseEntity<Employee>(employeeService.save(employee), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
// Update employee in database
	@PatchMapping("/api/employees")
	public ResponseEntity<Employee> patchEmployee(@RequestBody Employee employee) {
		try {

			return new ResponseEntity<Employee>(employeeService.save(employee), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
// Delete employee in database
	@DeleteMapping(value = "/api/employees/{id}")
	public ResponseEntity<Employee> employeeDelete(@PathVariable int id) {
		try {
			return new ResponseEntity<>(employeeService.deleteById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}