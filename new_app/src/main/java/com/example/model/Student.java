package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String idx;
	private String firstName;
	private String lastName;

	public Student() {

	}

	public Student(Integer id, String idx, String firstName, String lastName) {
		super();
		this.id = id;
		this.idx = idx;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Student(String idx, String firstName, String lastName) {
		super();
		this.idx = idx;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdx() {
		return idx;
	}

	public void setIdx(String idx) {
		this.idx = idx;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", idx=" + idx + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
