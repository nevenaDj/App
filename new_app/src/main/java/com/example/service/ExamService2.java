package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Exam;
import com.example.repository.ExamRepository2;

@Service
public class ExamService2 {
	@Autowired
	private ExamRepository2 examRepository;

	public List<Exam> getExams() {
		return examRepository.findAll();
	}

	public Exam getExam(Integer id) {
		return examRepository.getOne(id);
	}

	public void addExam(Exam exam) {
		examRepository.save(exam);
	}

}
