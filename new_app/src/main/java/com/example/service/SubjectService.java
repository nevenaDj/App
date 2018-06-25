package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Subject;
import com.example.repository.SubjectRepository;

@Service
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;

	public void readSubjects() {
		subjectRepository.readSubjects();
	}

	public void saveSubjects() {
		subjectRepository.saveSubjects();
	}

	public List<Subject> getSubject() {
		return subjectRepository.getSubjects();
	}

	public Subject getSubject(Integer id) {
		return subjectRepository.getSubject(id);
	}

	public Subject getSubject(String name) {
		return subjectRepository.getSubject(name);
	}

	public void addSubject(Subject subject) {
		subject.setId(subjectRepository.count());
		subjectRepository.addSubject(subject);
	}
}
