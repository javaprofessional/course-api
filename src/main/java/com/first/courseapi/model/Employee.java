package com.first.courseapi.model;

import java.util.Date;

public class Employee {
	String name;
	Date dateofbirth;
	String gender;
	long zipcode;

	public Employee(String name, Date dateofbirth, String gender, long zipcode) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.zipcode = zipcode;
	}

	public String getEmployee() {
		return name;
	}

	public void setEmployee(String employee) {
		this.name = employee;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getZipcode() {	
		return zipcode;
	}

	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}
	
	
	@Override
    public String toString(){
        return "name:"+name+", dateofbirth:" +dateofbirth+", gender:" +gender+", zipcode:" +zipcode;
    }
	

}
