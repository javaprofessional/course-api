package com.first.courseapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.first.courseapi.model.CustomerVO;
import com.first.courseapi.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerservice;

	@PostMapping("create/customer")
	public ResponseEntity<String> creatingCustomer(@RequestBody CustomerVO cusvo) {
		customerservice.addingCustomer(cusvo);
		return ResponseEntity.ok("Added succefully");
	}

	@GetMapping("/customername/{pattern}")
	public List<CustomerVO> searchByName(@PathVariable("pattern") String patteren) {
		List<CustomerVO> customervoList = customerservice.getCustomerByname(patteren);
		return customervoList;
	}

	@GetMapping("/updatecustomer/{name}/{customerid}/{lastname}")
	public CustomerVO searchUpdateName(@PathVariable("name") String name, @PathVariable("customerid") int cusid,
			@PathVariable("lastname") String lastname) {
		return customerservice.updatingName(name, cusid, lastname);

	}
	@GetMapping("/Customer")
	public List<CustomerVO> allCustomer(){
		return customerservice.getCustomerList();
	}

}
