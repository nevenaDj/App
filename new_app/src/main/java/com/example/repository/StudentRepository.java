package com.example.repository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.model.Student;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class StudentRepository {
	List<Student> students = new ArrayList<>();
	Map<Integer, Student> studentsMap = new HashMap<Integer, Student>();

	public void readStudents() {
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Student>> mapType = new TypeReference<List<Student>>() {
		};
		InputStream is = TypeReference.class.getResourceAsStream("/json/students.json");
		try {
			students = mapper.readValue(is, mapType);
			for (Student student : students) {
				studentsMap.put(student.getId(), student);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}

	public void saveStudents() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("src\\main\\resources\\json\\students.json"), students);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Student getStudent(Integer id) {
		return studentsMap.get(id);

	}

	public Student getStudent(String firstName, String lastName) {
		for (Student student : students) {
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
				return student;
			}
		}
		return null;
	}

	public Student getStudentByIdx(Integer idx) {
		for (Student student : students) {
			if (student.getIdx().equals(idx)) {
				return student;
			}
		}
		return null;
	}

	public void addStudent(Student student) {
		students.add(student);
	}

	public List<Student> getStudents() {
		return students;
	}

	public Integer count() {
		return students.size();
	}

}
