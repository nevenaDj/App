package com.example.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.model.Student;
import com.example.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	public void readStudents() {
		studentService.readStudents();
	}

	public void saveStudents() {
		studentService.saveStudents();
	}

	public void getStudents() {
		List<Student> students = studentService.getStudents();

		for (Student student : students) {
			System.out.println(student);
		}
	}

	public void addStudent() {
		Scanner in = new Scanner(System.in);
		System.out.println("Ime: ");
		String firstName = in.nextLine();
		System.out.println("Prezime:");
		String lastName = in.nextLine();
		System.out.println("Indeks:");
		String idx = in.nextLine();
		Student student = new Student(idx, firstName, lastName);
		studentService.addStudent(student);
	}

	public void getStudent() {
		Scanner in = new Scanner(System.in);
		System.out.println("Ime: ");
		String firstName = in.nextLine();
		System.out.println("Prezime:");
		String lastName = in.nextLine();

		Student student = studentService.getStudent(firstName, lastName);
		if (student != null) {
			System.out.println(student);
		} else {
			System.out.println("Student nije pronadjen!");
		}
	}

}
