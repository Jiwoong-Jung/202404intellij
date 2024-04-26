package com.green.university.repository.interfaces;

import org.apache.ibatis.annotations.Mapper;

import com.green.university.dto.response.QuestionDto;

@Mapper
public interface QuestionRepository {
	public QuestionDto findAll();
}
