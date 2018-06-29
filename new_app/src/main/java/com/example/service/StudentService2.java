package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.model.Student;
import com.example.model.User;
import com.example.repository.StudentRepository2;
import com.example.repository.UserRepository;

@Service
public class StudentService2 {
	@Autowired
	private StudentRepository2 studentRepository;
	@Autowired
	private UserRepository userRepository;

	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student getStudent(Integer id) {
		return studentRepository.getOne(id);
	}

	public void addStudent(Student student) {
		studentRepository.save(student);
	}

	public List<User> getAllStudents() {
		List<User> users = userRepository.findAll();

		List<User> students = new ArrayList<>();

		for (User user : users) {
			for (Role role : user.getRoles()) {
				if (role.getAuthority().equals("ROLE_STUDENT")) {
					students.add(user);
				}

			}

		}
		return students;
	}

}
