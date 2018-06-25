package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Exam;
import com.example.repository.ExamRepository;

@Service
public class ExamService {
	@Autowired
	private ExamRepository examRepository;

	public void readExams() {
		examRepository.readExams();
	}

	public void saveExams() {
		examRepository.saveExams();
	}

	public List<Exam> getExams() {
		return examRepository.getExams();
	}

	public Exam getExam(Integer id) {
		return examRepository.getExam(id);
	}

	public void addExam(Exam exam) {
		exam.setId(examRepository.count());
		examRepository.addExam(exam);
	}

}
