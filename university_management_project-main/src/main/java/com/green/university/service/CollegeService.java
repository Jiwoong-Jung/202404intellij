package com.green.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.university.repository.interfaces.CollegeRepository;
import com.green.university.repository.interfaces.DepartmentRepository;
import com.green.university.repository.model.College;
import com.green.university.repository.model.Department;

/**
 * 
 * @author 서영
 *
 */

@Service
public class CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	/**
	 * @param college_id
	 * @return id로 해당 단과대 정보 가져옴
	 */
	public College readCollById(Integer id) {

		College collEntity = collegeRepository.selectCollegeDtoById(id);
		return collEntity;
	}

	/**
	 * @param dept_id
	 * @return id로 해당 학과 정보 가져옴
	 */
	public Department readDeptById(Integer id) {

		Department deptEntity = departmentRepository.selectById(id);
		return deptEntity;
	}

	/**
	 * @return 전체 학과 정보 조회
	 */
	public List<Department> readDeptAll() {

		List<Department> deptEntityList = departmentRepository.selectByDepartmentDto();
		return deptEntityList;
	}

}
