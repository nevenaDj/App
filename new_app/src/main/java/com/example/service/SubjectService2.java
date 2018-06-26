package com.example.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Departman;
import com.example.model.Professor;
import com.example.model.Subject;
import com.example.repository.ExamRepository2;
import com.example.repository.SubjectRepository2;

@Service
public class SubjectService2 {
	@Autowired
	private SubjectRepository2 subjectRepository;

	@Autowired
	private ExamRepository2 examRepository;

	public List<Subject> getSubject() {
		return subjectRepository.findAll();
	}

	public Subject getSubject(Integer id) {
		return subjectRepository.getOne(id);
	}

	public boolean addSubject(Subject subject, Departman departman, Professor professor) {
		if (!professor.getDepartman().getId().equals(departman.getId())) {
			return false;
		}
		subject.setDepartman(departman);
		subject.setProfessor(professor);
		subjectRepository.save(subject);
		return true;
	}

	public List<Subject> getSubjectsSort() {
		List<Subject> subjects = subjectRepository.findAll();

		Map<Subject, Integer> subjectMap = new HashMap<>();
		for (Subject subject : subjects) {
			Integer count = examRepository.getStudentCount(subject.getId(), 5);
			subjectMap.put(subject, count);
		}

		subjects.clear();
		for (Entry<Subject, Integer> e : entriesSortedByValues(subjectMap)) {
			subjects.add(e.getKey());
			System.out.println(e.getKey().getName() + " " + e.getValue());
		}

		return subjects;

	}

	static <K, V extends Comparable<? super V>> List<Entry<K, V>> entriesSortedByValues(Map<K, V> map) {

		List<Entry<K, V>> sortedEntries = new ArrayList<Entry<K, V>>(map.entrySet());

		Collections.sort(sortedEntries, new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e2.getValue().compareTo(e1.getValue());
			}
		});

		return sortedEntries;
	}

}
