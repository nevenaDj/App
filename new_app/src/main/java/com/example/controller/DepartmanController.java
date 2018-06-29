package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.DepartmanDTO;
import com.example.model.Departman;
import com.example.service.DepartmanService;

@RestController
@RequestMapping("/api")
public class DepartmanController {
	@Autowired
	private DepartmanService departmanService;
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/departman")
	public ResponseEntity<Void> addDepartman(@RequestBody DepartmanDTO departman) {
		departmanService.addDepartman(modelMapper.map(departman, Departman.class));
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/departman")
	public ResponseEntity<List<DepartmanDTO>> getDepartmans() {
		List<Departman> departmans = departmanService.findAll();

		List<DepartmanDTO> departmanDTOs = new ArrayList<>();
		for (Departman departman : departmans) {
			departmanDTOs.add(modelMapper.map(departman, DepartmanDTO.class));

		}

		return new ResponseEntity<>(departmanDTOs, HttpStatus.OK);
	}

	@GetMapping("/departmans")
	public ResponseEntity<List<DepartmanDTO>> getDepartmansPage(Pageable page) {
		Page<Departman> departmans = departmanService.findAllPage(page);

		List<DepartmanDTO> departmanDTOs = new ArrayList<>();
		for (Departman departman : departmans) {
			departmanDTOs.add(modelMapper.map(departman, DepartmanDTO.class));

		}

		return new ResponseEntity<>(departmanDTOs, HttpStatus.OK);
	}

	@GetMapping("/departmans/count")
	public ResponseEntity<Long> getCount() {
		Long count = departmanService.getCount();
		return new ResponseEntity<>(count, HttpStatus.OK);
	}

}
