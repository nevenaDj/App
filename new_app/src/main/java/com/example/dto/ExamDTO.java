package com.example.dto;

public class ExamDTO {
	private Integer id;
	private StudentDTO student;
	private SubjectDTO subject;
	private Integer rating;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public SubjectDTO getSubject() {
		return subject;
	}

	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
