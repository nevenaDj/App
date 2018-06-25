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

import com.example.dto.StudentDTO;
import com.example.model.Student;
import com.example.service.StudentService2;

@RestController
@RequestMapping("/api")
public class StudentControllerRest {
	@Autowired
	private StudentService2 studentService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/student")
	public ResponseEntity<Void> addStudent(@RequestBody StudentDTO student) {
		studentService.addStudent(modelMapper.map(student, Student.class));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer id) {
		Student student = studentService.getStudent(id);
		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);

		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}

}
