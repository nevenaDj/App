package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Departman;
import com.example.model.Professor;
import com.example.repository.ProfessorRepository;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;

	public void addProfessor(Professor professor, Departman departman) {
		professor.setDepartman(departman);
		professorRepository.save(professor);
	}

	public Professor findOne(Integer id) {
		return professorRepository.getOne(id);
	}

}
