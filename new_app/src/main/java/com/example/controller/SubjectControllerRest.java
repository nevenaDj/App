package com.example.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.dto.SubjectDTO;
import com.example.model.Departman;
import com.example.model.Professor;
import com.example.model.Subject;
import com.example.service.DepartmanService;
import com.example.service.ProfessorService;
import com.example.service.SubjectService2;

@RestController
@RequestMapping("/api")
public class SubjectControllerRest {
	private static final Logger logger = LoggerFactory.getLogger(SubjectControllerRest.class);
	@Autowired
	private SubjectService2 subjectService;
	@Autowired
	private ProfessorService professorService;
	@Autowired
	private DepartmanService departmanService;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/departman/{id}/professor/{idP}/subject")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<Void> addSubject(@PathVariable("id") Integer id, @PathVariable("idP") Integer idP,
			@RequestBody SubjectDTO subject) {
		Professor professor = professorService.findOne(idP);
		if (professor == null) {
			logger.error("Nastavnik ne postoji.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Departman departman = departmanService.findOne(id);
		if (departman == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		boolean flag = subjectService.addSubject(modelMapper.map(subject, Subject.class), departman, professor);

		if (!flag) {
			logger.error("Nastavnik ne predaje na departmanu predmeta.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/subject/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<SubjectDTO> getSubject(@PathVariable Integer id) {
		Subject subject = subjectService.getSubject(id);
		if (subject == null) {
			logger.error("Predmet ne postoji.");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		SubjectDTO subjectDTO = modelMapper.map(subject, SubjectDTO.class);

		return new ResponseEntity<>(subjectDTO, HttpStatus.OK);
	}

	@GetMapping("/subjects")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<List<SubjectDTO>> getSubjects() {
		List<Subject> subjects = subjectService.getSubjectsSort();

		List<SubjectDTO> subjectDTOs = new ArrayList<>();
		for (Subject subject : subjects) {
			subjectDTOs.add(modelMapper.map(subject, SubjectDTO.class));

		}

		return new ResponseEntity<>(subjectDTOs, HttpStatus.OK);
	}

}
