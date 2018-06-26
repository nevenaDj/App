package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.ApplyingExams;

@Repository
public interface ApplyingExamsRepository extends JpaRepository<ApplyingExams, Integer> {
	@Query("SELECT a FROM ApplyingExams a WHERE a.examinationPeriod.subject.id = ?1 AND a.student.id = ?2 AND flag = true")
	public ApplyingExams getApplyingExam(Integer idSubject, Integer idStudent);

}
