package com.example.dto;

import java.util.HashSet;
import java.util.Set;

public class StudentDTO {

	private Integer id;
	private String idx;
	private String firstName;
	private String lastName;

	private Set<ExamDTO> exams = new HashSet<>();

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

	public Set<ExamDTO> getExams() {
		return exams;
	}

	public void setExams(Set<ExamDTO> exams) {
		this.exams = exams;
	}

}
