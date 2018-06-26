package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.ExaminationPeriod;

@Repository
public interface ExaminationPeriodRepository extends JpaRepository<ExaminationPeriod, Integer> {

}
