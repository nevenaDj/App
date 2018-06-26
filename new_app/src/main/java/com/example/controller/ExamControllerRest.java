package com.example.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ExamDTO;
import com.example.model.Exam;
import com.example.model.Student;
import com.example.model.Subject;
import com.example.service.ExamService2;
import com.example.service.StudentService2;
import com.example.service.SubjectService2;

@RestController
@RequestMapping("/api")
public class ExamControllerRest {
	private static final Logger logger = LoggerFactory.getLogger(ExamControllerRest.class);
	@Autowired
	private ExamService2 examService;
	@Autowired
	private SubjectService2 subjectService;
	@Autowired
	private StudentService2 studentService;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/subject/{id}/student/{idS}/exam")
	public ResponseEntity<Void> addExam(@RequestBody ExamDTO exam, @PathVariable("id") Integer id,
			@PathVariable("idS") Integer idS) {
		Student student = studentService.getStudent(idS);
		if (student == null) {
			logger.error("Student ne postoji.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Subject subject = subjectService.getSubject(id);

		if (subject == null) {
			logger.error("Predmet ne postoji.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		boolean flag = examService.addExam(modelMapper.map(exam, Exam.class), subject, student);
		if (!flag) {
			logger.error("Prijava ispita ne postoji.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/exam/{id}")
	public ResponseEntity<ExamDTO> getExam(@PathVariable Integer id) {
		Exam exam = examService.getExam(id);
		if (exam == null) {
			logger.error("Ispit ne postoji.");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ExamDTO examDTO = modelMapper.map(exam, ExamDTO.class);

		return new ResponseEntity<>(examDTO, HttpStatus.OK);
	}
}
