package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.model.Departman;
import com.example.model.Professor;
import com.example.model.User;
import com.example.repository.ProfessorRepository;
import com.example.repository.UserRepository;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository professorRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public void addProfessor(Professor professor, Departman departman) {
		professor.setDepartman(departman);
		User user = professor.getUser();
		user.setPassword(passwordEncoder.encode("password"));
		user = userRepository.save(user);

		professor.setUser(user);
		professorRepository.save(professor);
	}

	public Professor findOne(Integer id) {
		return professorRepository.getOne(id);
	}

	public List<Professor> findAll() {
		return professorRepository.findAll();
	}

	public Page<Professor> findAllPage(Pageable page) {
		return professorRepository.findAll(page);
	}

}
