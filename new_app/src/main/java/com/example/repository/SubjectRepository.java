package com.example.repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.model.Subject;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class SubjectRepository {
	List<Subject> subjects = new ArrayList<>();
	Map<Integer, Subject> subjectsMap = new HashMap<Integer, Subject>();

	public void readSubjects() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Subject>> mapType = new TypeReference<List<Subject>>() {
		};
		InputStream is = TypeReference.class.getResourceAsStream("/json/subjects.json");
		try {
			subjects = mapper.readValue(is, mapType);
			for (Subject subject : subjects) {
				subjectsMap.put(subject.getId(), subject);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void saveSubjects() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("src\\main\\resources\\json\\subjects.json"), subjects);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Subject getSubject(String name) {
		for (Subject subject : subjects) {
			if (subject.getName().equals(name)) {
				return subject;
			}
		}
		return null;
	}

	public Subject getSubject(Integer id) {
		return subjectsMap.get(id);
	}

	public void addSubject(Subject subject) {
		subjects.add(subject);
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public Integer count() {
		return subjects.size();
	}

}
