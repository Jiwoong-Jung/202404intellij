package com.green.university.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.university.dto.StudentListForm;
import com.green.university.repository.interfaces.StudentRepository;
import com.green.university.repository.model.Student;

/**
 * 학생 관련 서비스
 * 
 * @author 김지현
 *
 */
@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	/**
	 * 
	 * @param studentListForm
	 * @return 학생 리스트
	 */
	@Transactional
	public List<Student> readStudentList(StudentListForm studentListForm) {

		List<Student> list = null;

		if (studentListForm.getStudentId() != null) {
			list = studentRepository.selectByStudentId(studentListForm);
		} else if (studentListForm.getDeptId() != null) {
			list = studentRepository.selectByDepartmentId(studentListForm);
		} else {
			list = studentRepository.selectStudentList(studentListForm);
		}

		return list;
	}

	/**
	 * 
	 * @param studentListForm
	 * @return 학생 수
	 */
	@Transactional
	public Integer readStudentAmount(StudentListForm studentListForm) {

		Integer amount = null;
		if (studentListForm.getDeptId() != null) {
			amount = studentRepository.selectStudentAmountByDeptId(studentListForm.getDeptId());
		} else {
			amount = studentRepository.selectStudentAmount();
		}

		return amount;
	}

	/**
	 * 학생 학년과 학기 업데이트
	 */
	@Transactional
	public void updateStudentGradeAndSemester() {
		studentRepository.updateStudentGradeAndSemester1_2();
		studentRepository.updateStudentGradeAndSemester2_1();
		studentRepository.updateStudentGradeAndSemester2_2();
		studentRepository.updateStudentGradeAndSemester3_1();
		studentRepository.updateStudentGradeAndSemester3_2();
		studentRepository.updateStudentGradeAndSemester4_1();
		studentRepository.updateStudentGradeAndSemester4_2();
	}

}
