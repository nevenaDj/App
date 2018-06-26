package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Departman;

@Repository
public interface DepartmanRepository extends JpaRepository<Departman, Integer> {

}
