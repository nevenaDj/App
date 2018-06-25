package com.example.repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.model.Exam;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ExamRepository {
	List<Exam> exams = new ArrayList<>();
	Map<Integer, Exam> examsMap = new HashMap<Integer, Exam>();

	public void readExams() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Exam>> mapType = new TypeReference<List<Exam>>() {
		};
		InputStream is = TypeReference.class.getResourceAsStream("/json/exams.json");
		try {
			exams = mapper.readValue(is, mapType);
			for (Exam exam : exams) {
				examsMap.put(exam.getId(), exam);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void saveExams() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("src\\main\\resources\\json\\exams.json"), exams);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Exam getExam(Integer id) {
		return examsMap.get(id);

	}

	public void addExam(Exam exam) {
		exams.add(exam);
	}

	public List<Exam> getExams() {
		return exams;
	}

	public Integer count() {
		return exams.size();
	}

}
