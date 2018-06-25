package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Student;
import com.example.repository.StudentRepository2;

@Service
public class StudentService2 {
	@Autowired
	private StudentRepository2 studentRepository;

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student getStudent(Integer id) {
		return studentRepository.getOne(id);
	}

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

}
