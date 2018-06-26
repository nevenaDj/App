package com.example.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ExaminationPeriodDTO;
import com.example.model.ExaminationPeriod;
import com.example.model.Subject;
import com.example.service.ExaminationPeriodService;
import com.example.service.SubjectService2;

@RestController
@RequestMapping("/api")
public class ExaminationPeriodController {
	private static final Logger logger = LoggerFactory.getLogger(ExaminationPeriodController.class);
	@Autowired
	private ExaminationPeriodService examinationPeriodService;
	@Autowired
	private SubjectService2 subjectService;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/subject/{id}/examinationPeriod")
	public ResponseEntity<Void> addExaminationPeriod(@PathVariable("id") Integer id,
			@RequestBody ExaminationPeriodDTO examinationPeriod) {
		Subject subject = subjectService.getSubject(id);
		if (subject == null) {
			logger.error("Predmet ne postoji.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		examinationPeriodService.addExaminationPeriod(modelMapper.map(examinationPeriod, ExaminationPeriod.class),
				subject);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
