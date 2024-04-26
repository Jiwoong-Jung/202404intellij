package com.green.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.university.dto.response.QuestionDto;
import com.green.university.repository.interfaces.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Transactional
	public QuestionDto readQuestion() {
		QuestionDto dto = questionRepository.findAll();
		return dto;
	}
}
