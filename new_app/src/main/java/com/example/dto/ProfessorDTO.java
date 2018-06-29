package com.example.dto;

public class ProfessorDTO {
	private Integer id;
	private UserDTO user;
	private DepartmanDTO departman;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public DepartmanDTO getDepartman() {
		return departman;
	}

	public void setDepartman(DepartmanDTO departman) {
		this.departman = departman;
	}

}
