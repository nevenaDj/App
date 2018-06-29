package com.example.controller;

import java.util.ArrayList;
import java.util.List;

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

import com.example.dto.DepartmanDTO;
import com.example.dto.ProfessorDTO;
import com.example.model.Departman;
import com.example.model.Professor;
import com.example.service.DepartmanService;
import com.example.service.ProfessorService;

@RestController
@RequestMapping("/api")
public class ProfessorController {
	private static final Logger logger = LoggerFactory.getLogger(ProfessorController.class);
	@Autowired
	private ProfessorService professorService;
	@Autowired
	private DepartmanService departmanService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/departman/{id}/professor")
	public ResponseEntity<Void> addProfessor(@PathVariable Integer id, @RequestBody ProfessorDTO professor) {

		Departman departman = departmanService.findOne(id);
		if (departman == null) {
			logger.error("Departman ne postoji.");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		professorService.addProfessor(modelMapper.map(professor, Professor.class), departman);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/professor")
	public ResponseEntity<List<ProfessorDTO>> getProfessors() {
		List<Professor> professors = professorService.findAll();

		List<ProfessorDTO> professorDTOs = new ArrayList<>();
		for (Professor professor : professors) {
			professorDTOs.add(modelMapper.map(professor, ProfessorDTO.class));

		}

		return new ResponseEntity<>(professorDTOs, HttpStatus.OK);
	}

}
