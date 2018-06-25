package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Subject;

@Repository
public interface SubjectRepository2 extends JpaRepository<Subject, Integer> {

	Subject findByName(String name);

}
