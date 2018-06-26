package com.example.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Exam;

@Repository
public interface ExamRepository2 extends JpaRepository<Exam, Integer> {
	@Query("SELECT e FROM Exam e WHERE e.student.id = ?1 AND e.rating > ?2")
	public Set<Exam> getExams(Integer idStudent, Integer rating);

	@Query("SELECT AVG(e.rating) FROM Exam e WHERE e.student.id = ?1 AND e.rating > ?2")
	public Double getStudentRating(Integer idStudent, Integer rating);

	@Query("SELECT COUNT(e.student) FROM Exam e WHERE e.subject.id = ?1 AND e.rating > ?2")
	public Integer getStudentCount(Integer idSubject, Integer rating);

}
