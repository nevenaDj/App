package com.example.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ExamDTO;
import com.example.dto.StudentDTO;
import com.example.dto.SubjectDTO;
import com.example.model.Exam;
import com.example.model.Student;
import com.example.service.ExamService2;
import com.example.service.StudentService2;

@RestController
@RequestMapping("/api")
public class StudentControllerRest {
	private static final Logger logger = LoggerFactory.getLogger(StudentControllerRest.class);
	@Autowired
	private StudentService2 studentService;

	@Autowired
	private ExamService2 examService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/student")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Void> addStudent(@RequestBody StudentDTO student) {
		studentService.addStudent(modelMapper.map(student, Student.class));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/student/{id}")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<StudentDTO> getStudent(@PathVariable Integer id) {
		Student student = studentService.getStudent(id);
		if (student == null) {
			logger.error("Student ne postoji.");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);

		return new ResponseEntity<>(studentDTO, HttpStatus.OK);
	}

	@GetMapping("/students")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<List<StudentDTO>> getStudents() {
		List<Student> students = studentService.getStudents();

		List<StudentDTO> studentDTOs = new ArrayList<>();
		for (Student student : students) {
			StudentDTO studentDTO = modelMapper.map(student, StudentDTO.class);

			Set<Exam> exams = examService.getExamsOfStudents(student.getId(), 5);

			Set<ExamDTO> examDTOs = new HashSet<>();
			for (Exam exam : exams) {
				ExamDTO examDTO = modelMapper.map(exam, ExamDTO.class);
				examDTO.setSubject(modelMapper.map(exam.getSubject(), SubjectDTO.class));
				examDTO.setStudent(null);
				examDTOs.add(examDTO);
			}

			studentDTO.setExams(examDTOs);
			studentDTOs.add(studentDTO);

		}

		return new ResponseEntity<>(studentDTOs, HttpStatus.OK);
	}

	@GetMapping("/student/{id}/rating")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Double> getStudentRating(@PathVariable Integer id) {
		Student student = studentService.getStudent(id);
		if (student == null) {
			logger.error("Student ne postoji.");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Double rating = examService.getStudentAvgRating(id, 5);
		return new ResponseEntity<>(rating, HttpStatus.OK);
	}

}
