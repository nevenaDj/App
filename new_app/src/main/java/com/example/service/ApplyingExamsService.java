package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.ApplyingExams;
import com.example.model.ExaminationPeriod;
import com.example.model.User;
import com.example.repository.ApplyingExamsRepository;

@Service
public class ApplyingExamsService {
	@Autowired
	private ApplyingExamsRepository applyingExamsRepository;

	public void addApplyingExamRepository(ExaminationPeriod examinationPeriod, User student) {
		ApplyingExams applyingExams = new ApplyingExams();
		applyingExams.setExaminationPeriod(examinationPeriod);
		applyingExams.setStudent(student);
		applyingExams.setFlag(true);
		applyingExamsRepository.save(applyingExams);
	}

	public ApplyingExams findOne(Integer id) {
		return applyingExamsRepository.getOne(id);
	}

	public void changeApplyingExam(ApplyingExams applyingExams) {
		applyingExams.setFlag(false);
		applyingExamsRepository.save(applyingExams);
	}

}
