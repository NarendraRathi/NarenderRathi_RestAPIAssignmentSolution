package com.greatlearning.EmployeeManagementSystemApplication.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {

	@GetMapping("/")
	public String home() {
		return ("<h1> Spring Boot Project </h1>");
	}
}