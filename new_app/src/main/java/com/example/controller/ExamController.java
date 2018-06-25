package com.example.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.model.Exam;
import com.example.model.Student;
import com.example.model.Subject;
import com.example.service.ExamService;
import com.example.service.StudentService;
import com.example.service.SubjectService;

@Controller
public class ExamController {
	@Autowired
	private ExamService examService;
	@Autowired
	private SubjectService subjectService;

	@Autowired
	private StudentService studentService;

	public void readExams() {
		examService.readExams();
	}

	public void saveExams() {
		examService.saveExams();
	}

	public void getExams() {
		List<Exam> exams = examService.getExams();

		for (Exam exam : exams) {
			System.out.println(exam);
		}
	}

	public void addExam() {
		Scanner in = new Scanner(System.in);

		List<Subject> subjects = subjectService.getSubject();
		for (Subject subject : subjects) {
			System.out.println(subject);
		}

		System.out.println("");
		System.out.println("Id predmeta:");

		Integer id = in.nextInt();

		Subject subject = subjectService.getSubject(id);

		List<Student> students = studentService.getStudents();
		for (Student student : students) {
			System.out.println(student);
		}

		System.out.println("");
		System.out.println("Id studenta:");

		id = in.nextInt();

		Student student = studentService.getStudent(id);

		Exam exam = new Exam(student, subject);

		examService.addExam(exam);

	}
}
