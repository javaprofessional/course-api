package com.first.courseapi.model;

import java.util.Date;

public class Friend {

	String name;
	Date dateofbirth;
	String gender;
	long zipcode;

	public Friend(String name, Date dateofbirth, String gender, long zipcode) {
		super();
		this.name = name;
		this.dateofbirth = dateofbirth;
		this.gender = gender;
		this.zipcode = zipcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
