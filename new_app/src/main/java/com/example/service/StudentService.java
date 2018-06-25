package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public void readStudents() {
		studentRepository.readStudents();
	}

	public void saveStudents() {
		studentRepository.saveStudents();
	}

	public List<Student> getStudents() {
		return studentRepository.getStudents();
	}

	public Student getStudent(Integer id) {
		return studentRepository.getStudent(id);
	}

	public Student getStudentByIdx(Integer idx) {
		return studentRepository.getStudentByIdx(idx);
	}

	public Student getStudent(String firstName, String lastName) {
		return studentRepository.getStudent(firstName, lastName);
	}

	public void addStudent(Student student) {
		student.setId(studentRepository.count());
		studentRepository.addStudent(student);
	}

}
