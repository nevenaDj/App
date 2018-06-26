package com.example.dto;

public class ProfessorDTO {
	private Integer id;
	private String firstName;
	private String lastName;

	private DepartmanDTO departman;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public DepartmanDTO getDepartman() {
		return departman;
	}

	public void setDepartman(DepartmanDTO departman) {
		this.departman = departman;
	}

}
