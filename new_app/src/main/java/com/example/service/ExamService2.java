package com.example.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.ApplyingExams;
import com.example.model.Exam;
import com.example.model.Student;
import com.example.model.Subject;
import com.example.repository.ApplyingExamsRepository;
import com.example.repository.ExamRepository2;

@Service
public class ExamService2 {
	@Autowired
	private ExamRepository2 examRepository;
	@Autowired
	private ApplyingExamsRepository applyingExamsRepository;

	public List<Exam> getExams() {
		return examRepository.findAll();
	}

	public Exam getExam(Integer id) {
		return examRepository.getOne(id);
	}

	public boolean addExam(Exam exam, Subject subject, Student student) {
		ApplyingExams applyingExams = applyingExamsRepository.getApplyingExam(subject.getId(), student.getId());
		if (applyingExams == null) {
			return false;
		}
		exam.setStudent(student);
		exam.setSubject(subject);
		examRepository.save(exam);
		return true;
	}

	public Set<Exam> getExamsOfStudents(Integer idStudent, Integer rating) {
		return examRepository.getExams(idStudent, rating);
	}

	public Double getStudentAvgRating(Integer idStudent, Integer rating) {
		return examRepository.getStudentRating(idStudent, rating);
	}

}
