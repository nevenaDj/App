package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Departman;
import com.example.repository.DepartmanRepository;

@Service
public class DepartmanService {
	@Autowired
	private DepartmanRepository departmanRepository;

	public void addDepartman(Departman departman) {
		departmanRepository.save(departman);
	}

	public Departman findOne(Integer id) {
		return departmanRepository.getOne(id);
	}

}
