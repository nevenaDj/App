package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	public List<Departman> findAll() {
		return departmanRepository.findAll();
	}

	public Page<Departman> findAllPage(Pageable page) {
		return departmanRepository.findAll(page);
	}

	public Long getCount() {
		return departmanRepository.count();
	}

}
