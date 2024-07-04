package com.School_ERP.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students") // Adjust table name as needed
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	private String fname;
	private String lname;
	private String contact;
	private String address;
	private String email;
	private String gender;
	private String bloodGroup; // Assuming camelCase
	private String fatherName; // Assuming camelCase
	private String motherName; // Assuming camelCase
	private String dob;
	private String section;
	private String standard;
	private LocalDate admDate; // Assuming camelCase

	@ManyToOne
	@JoinColumn(name = "sub_code")
	private Subject subject;

	@ManyToOne
	@JoinColumn(name = "bus_id")
	private Bus bus;

	// Getters and Setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public LocalDate getAdmDate() {
		return admDate;
	}

	public void setAdmDate(LocalDate admDate) {
		this.admDate = admDate;
	}





}
