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

import com.example.dto.SubjectDTO;
import com.example.model.Subject;
import com.example.service.SubjectService2;

@RestController
@RequestMapping("/api")
public class SubjectControllerRest {
	@Autowired
	private SubjectService2 subjectService;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/subject")
	public ResponseEntity<Void> addSubject(@RequestBody SubjectDTO subject) {
		subjectService.addSubject(modelMapper.map(subject, Subject.class));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/subject/{id}")
	public ResponseEntity<SubjectDTO> getSubject(@PathVariable Integer id) {
		Subject subject = subjectService.getSubject(id);
		if (subject == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		SubjectDTO subjectDTO = modelMapper.map(subject, SubjectDTO.class);

		return new ResponseEntity<>(subjectDTO, HttpStatus.OK);
	}

}
