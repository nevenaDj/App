package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.ExaminationPeriod;
import com.example.model.Subject;
import com.example.repository.ExaminationPeriodRepository;

@Service
public class ExaminationPeriodService {
	@Autowired
	private ExaminationPeriodRepository examinationPeriodRepository;

	public void addExaminationPeriod(ExaminationPeriod examinationPeriod, Subject subject) {
		examinationPeriod.setSubject(subject);
		examinationPeriodRepository.save(examinationPeriod);
	}

	public ExaminationPeriod findOne(Integer id) {
		return examinationPeriodRepository.getOne(id);
	}

	public List<ExaminationPeriod> findAll() {
		return examinationPeriodRepository.findAll();
	}

}
