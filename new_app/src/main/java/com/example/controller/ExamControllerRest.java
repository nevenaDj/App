package com.example.controller;

import org.modelmapper.ModelMapper;
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
import com.example.service.ExamService2;

@RestController
@RequestMapping("/api")
public class ExamControllerRest {
	@Autowired
	private ExamService2 examService;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/exam")
	public ResponseEntity<Void> addExam(@RequestBody ExamDTO exam) {
		examService.addExam(modelMapper.map(exam, Exam.class));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/exam/{id}")
	public ResponseEntity<ExamDTO> getExam(@PathVariable Integer id) {
		Exam exam = examService.getExam(id);
		if (exam == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		ExamDTO examDTO = modelMapper.map(exam, ExamDTO.class);

		return new ResponseEntity<>(examDTO, HttpStatus.OK);
	}
}
