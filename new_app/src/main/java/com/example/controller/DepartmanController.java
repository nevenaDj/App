package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
