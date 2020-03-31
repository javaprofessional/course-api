package com.first.courseapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.first.courseapi.entity.Customer;
import com.first.courseapi.model.CustomerVO;
import com.first.courseapi.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public String addingCustomer(CustomerVO custvo) {

		
		Customer customer = new Customer();
				customer.setCity(custvo.getCity());
		customer.setCustomerid(custvo.getCustomerid());
		
		/*Customer customer = new Customer(custvo.getCustomerid(), custvo.getCustomername(), custvo.getCity(),
				custvo.getDateofbirth(), custvo.getZipcode());*/
		customer.setCustomerid(custvo.getCustomerid());
		customer.setCustomername(custvo.getCustomername());
		customer.setDateofbirth(custvo.getDateofbirth());
		customer.setZipcode(custvo.getZipcode());
		
		
		
		customerRepository.save(customer);
		return ("Added");
	}

	public List<CustomerVO> getCustomerByname(String pattern) {
		// List<Customer> customerList= customerRepository.searchByPatternLike(pattern);
		List<Customer> customerList = customerRepository.findByCustomernameContainingIgnoreCase(pattern);
		List<CustomerVO> customervoList = new ArrayList<>();
              Customer customer = new Customer();
		for (@SuppressWarnings("unused") Customer customerV : customerList) {
					
			CustomerVO mycustomervo = conversion(customer);
			customervoList.add(mycustomervo);
		}
		return customervoList;

	}

	public CustomerVO conversion(Customer customer) {
		CustomerVO customervo = new CustomerVO(customer.getCustomerid(), customer.getCustomername(), customer.getCity(),
				customer.getDateofbirth(), customer.getZipcode());

		return customervo;

	}

	@Transactional
	public CustomerVO updatingName(String name, int cusid, String lastname) {
		String changedname = name + lastname;
		//String s = "successfully updated";
		CustomerVO customerVo = null;
		try {
			int updatedRowCount = customerRepository.updateCustomerName(name, cusid, changedname);
			if (updatedRowCount <= 0) {
				//s = "no matching found for update";
			}
			Customer changedCustomer = customerRepository
					.findByCustomernameContainingIgnoreCaseAndCustomerid(changedname, cusid);
			customerVo = conversion(changedCustomer);

		} catch (Exception e) {
			//s = "error occurred";
		}
		return customerVo;

	}

	public List<CustomerVO> getCustomerList() {
		List<Customer> customerList = customerRepository.findAll();
		List<CustomerVO> customervoList = new ArrayList<>();
		for (Customer customer : customerList) {
			CustomerVO customervo = conversion(customer);
			customervoList.add(customervo);
		}

		return customervoList;

	}

}
