package com.first.courseapi.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(generator = "UUID2")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")

	@Column(name = "id")
	UUID id;
	
	@Column(name = "user_id")
	int customerid;
	
	@Column(name = "username")
	String customername;
	
	@Column(name = "city")
	String city;
	
	@Column(name = "dateofbirth")
	Date dateofbirth;
	
	@Column(name = "zipcode")
	int zipcode;

	public Customer() {

	}

	public Customer(int customerid, String customername, String city, Date dateofbirth, int zipcode) {
		super();
		this.customerid = customerid;
		this.customername = customername;
		this.city = city;
		this.dateofbirth = dateofbirth;
		this.zipcode = zipcode;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
