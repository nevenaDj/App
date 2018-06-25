package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Exam;

@Repository
public interface ExamRepository2 extends JpaRepository<Exam, Integer> {

}
