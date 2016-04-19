package com.coba.model;

import java.sql.Date;

public class Customer {
	private String nik;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String address;
	private String noTelp;
	private Date dob;
	private String email;
	private Integer employeeId;
	private String status;

	public Customer(){}
	
	public Customer(String nik, String firstname, String lastname, String username, String password, String address,
			String noTelp, String email, Date dob, Integer employeeId) {
		this.nik = nik;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.dob = dob;
		this.email = email;
		this.employeeId = employeeId;
		this.noTelp = noTelp;
	}
	
	

	public Customer(String nik, String firstname, String lastname, String username, String password, String address,
			String noTelp, Date dob, String email, Integer employeeId, String status) {
		this.nik = nik;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.noTelp = noTelp;
		this.dob = dob;
		this.email = email;
		this.employeeId = employeeId;
		this.status = status;
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNoTelp() {
		return noTelp;
	}

	public void setNoTelp(String noTelp) {
		this.noTelp = noTelp;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}

