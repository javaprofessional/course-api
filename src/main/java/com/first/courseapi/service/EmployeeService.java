package com.first.courseapi.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.first.courseapi.model.Employee;

@Service
public class EmployeeService {
	List<Employee> employeeList = new ArrayList<>();

	public List<Employee> createEmployee(JsonNode jsonnode){
		Date date = null;

		SimpleDateFormat convert = new SimpleDateFormat("dd-MM-yyyy");
		try {
			date = convert.parse(jsonnode.get("dateofbirth").asText());
		} catch (ParseException e) {
			throw new IllegalArgumentException("Date of birth needs to be in the format of dd-mm-yyyy");
		}

		Employee emp = new Employee(jsonnode.get("name").asText(), date, jsonnode.get("gender").asText(),
				jsonnode.get("zipcode").asLong());
		employeeList.add(emp);
		System.out.println(""+employeeList);
		return employeeList;

	}

	public List<Employee> getEmployeeByName(String employeeName) {
		List<Employee> searchResultList = new ArrayList<>();
		for (Employee employee : employeeList) {
			if (employee.getEmployee().equalsIgnoreCase(employeeName)) {
				searchResultList.add(employee);
			}
		}
		return searchResultList;
	}

	public List<Employee> getEmployeeByGender(String gender) {
		List<Employee> searchResultList = new ArrayList<>();
		for (Employee employee : employeeList) {
			if (employee.getGender().equalsIgnoreCase(gender)) {
				searchResultList.add(employee);
			}
		}
		return searchResultList;
	}

	public List<Employee> getEmployeeByZipCode(long zipcode) {
		List<Employee> searchResultList = new ArrayList<>();
		for (Employee employee : employeeList) {
			if (employee.getZipcode() == zipcode) {
				searchResultList.add(employee);
			}
		}
		return searchResultList;
	}

}
