package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Subject;
import com.example.repository.SubjectRepository2;

@Service
public class SubjectService2 {
	@Autowired
	private SubjectRepository2 subjectRepository;

	public List<Subject> getSubject() {
		return subjectRepository.findAll();
	}

	public Subject getSubject(Integer id) {
		return subjectRepository.getOne(id);
	}

	public void addSubject(Subject subject) {
		subjectRepository.save(subject);
	}

}
