package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.ApplyingExams;
import com.example.model.ExaminationPeriod;
import com.example.model.User;
import com.example.security.jwt.JwtTokenUtils;
import com.example.service.ApplyingExamsService;
import com.example.service.ExaminationPeriodService;
import com.example.service.StudentService2;
import com.example.service.UserService;

@RestController
@RequestMapping("/api")
public class ApplyingExamsController {
	private static final Logger logger = LoggerFactory.getLogger(ApplyingExamsController.class);
	@Autowired
	private ApplyingExamsService applyingExamsService;
	@Autowired
	private StudentService2 studentService;
	@Autowired
	private UserService userService;
	@Autowired
	private ExaminationPeriodService examinationPeriodService;
	@Autowired
	private JwtTokenUtils jwtTokenProvider;

	@PostMapping("/examinationPeriod/{id}/applyingExam")
	//@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Void> addAExam(@PathVariable("id") Integer id, HttpServletRequest req) {
		ExaminationPeriod examinationPeriod = examinationPeriodService.findOne(id);
		if (examinationPeriod == null) {
			logger.error("Ispitni rok ne postoji.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		User student = userService.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));

		if (student == null) {
			logger.error("Student ne postoji.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		applyingExamsService.addApplyingExamRepository(examinationPeriod, student);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/applyingExam/{id}/remove")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Void> removeAExam(@PathVariable("id") Integer id) {
		ApplyingExams applyingExams = applyingExamsService.findOne(id);
		if (applyingExams == null) {
			logger.error("Prijava ispita ne postoji.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		applyingExamsService.changeApplyingExam(applyingExams);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
