package com.first.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.first.courseapi.model.Employee;
import com.first.courseapi.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeControler {
	
	@Autowired
	EmployeeService employeeService;
	
    @PostMapping("/postemployee")
    public ResponseEntity<String> addingEmployee(@RequestBody JsonNode jsonnode ){
    	System.out.println("controller input" + jsonnode);
    	employeeService.createEmployee(jsonnode);
    	return ResponseEntity.ok("created successfully");
    }
	 
	
	@GetMapping("/name/{name}") 
	public List<Employee> searchByName(@PathVariable("name") String name) {
		List<Employee> searchResultList = employeeService.getEmployeeByName(name);
		return searchResultList;
	}
	
	@GetMapping("/gender/{gender}") 
	public List<Employee> searchByGender(@PathVariable("gender") String gender) {
		List<Employee> searchResultList = employeeService.getEmployeeByGender(gender);
		return searchResultList;
	}
	
	@GetMapping("/zipcode/{zipcode}") 
	public List<Employee> searchByZipCode(@PathVariable("zipcode") long zipcode) {
		List<Employee> searchResultList = employeeService.getEmployeeByZipCode(zipcode);
		return searchResultList;
	}

	@GetMapping("/testmethod")
	public String testMethod() {
		return "hello";
	}

}
