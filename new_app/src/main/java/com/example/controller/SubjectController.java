package com.example.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.model.Subject;
import com.example.service.SubjectService;

@Controller
public class SubjectController {
	@Autowired
	private SubjectService subjectService;

	public void readSubjects() {
		subjectService.readSubjects();
	}

	public void saveSubjects() {
		subjectService.saveSubjects();
	}

	public void getSubjects() {
		List<Subject> subjects = subjectService.getSubject();

		for (Subject subject : subjects) {
			System.out.println(subject);
		}
	}

	public void addSubject() {
		Scanner in = new Scanner(System.in);
		System.out.println("Naziv: ");
		String name = in.nextLine();
		Subject subject = new Subject(name);
		subjectService.addSubject(subject);
	}

	public void getSubject() {
		Scanner in = new Scanner(System.in);
		System.out.println("Naziv: ");
		String name = in.nextLine();
		Subject subject = subjectService.getSubject(name);

		if (subject != null) {
			System.out.println(subject);
		} else {
			System.out.println("Trazeni predmet ne postoji!");
		}

	}

}
