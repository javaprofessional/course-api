package com.first.courseapi.model;

import java.util.Date;

public class CustomerVO {

	int customerid;
	String customername;
	String city;
	Date dateofbirth;
	int zipcode;

	public CustomerVO(int customerid, String customername, String city, Date dateofbirth, int zipcode) {
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
