package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Subject subject;

	public Exam() {

	}

	public Exam(Integer id, Student student, Subject subject) {
		super();
		this.id = id;
		this.student = student;
		this.subject = subject;
	}

	public Exam(Student student, Subject subject) {
		super();
		this.student = student;
		this.subject = subject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", student=" + student + ", subject=" + subject + "]";
	}

}
