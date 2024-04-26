package com.green.university.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.university.dto.CollegeFormDto;
import com.green.university.repository.model.College;

import lombok.AllArgsConstructor;

/*
 *  박성희
 *  단과대 repository
 */

@Mapper
public interface CollegeRepository {
	public int insert(CollegeFormDto CollegeFormDto);

	public List<College> selectCollegeDto();

	public int selectCollegeDtoByName(String name);
	public College selectCollegeDtoById(Integer id);
	public int deleteById(Integer id);
}
