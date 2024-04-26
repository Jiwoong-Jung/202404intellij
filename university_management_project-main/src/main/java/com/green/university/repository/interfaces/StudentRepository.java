package com.green.university.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.green.university.dto.CreateStudentDto;
import com.green.university.dto.FindIdFormDto;
import com.green.university.dto.FindPasswordFormDto;
import com.green.university.dto.StudentListForm;
import com.green.university.dto.UserUpdateDto;
import com.green.university.dto.response.StudentInfoDto;
import com.green.university.dto.response.UserInfoForUpdateDto;
import com.green.university.repository.model.Professor;
import com.green.university.repository.model.Student;
import com.green.university.repository.model.User;

/**
 * Student DAO
 * 
 * @author 김지현
 */
@Mapper
public interface StudentRepository {

	// student_tb에 insert
	public int insertToStudent(CreateStudentDto createStudentDto);

	// staff_tb에서 자동 생성된 id 받아오기
	public Integer selectIdByCreateStudentDto(CreateStudentDto createStudentDto);

	/**
	 * @author 서영 전체 학생의 id만 가져오기
	 */
	public List<Integer> selectIdList();

	/**
	 * @author 서영 특정 학생의 정보 가져오기
	 */
	public Student selectByStudentId(Integer studentId);

	// 업데이트용 정보 읽기
	public UserInfoForUpdateDto selectByUserId(Integer userId);

	// 유저 정보 업데이트
	public int updateStudent(UserUpdateDto userUpdateDto);

	// 학생 info id로 불러오기
	public StudentInfoDto selectStudentInfoById(Integer id);

	// id 찾기
	public Integer selectIdByNameAndEmail(FindIdFormDto findIdFormDto);

	// password 발급용 model 확인
	public Integer selectStudentByIdAndNameAndEmail(FindPasswordFormDto findPasswordFormDto);
	
	// 페이지별 학생 조회
	public List<Student> selectStudentList(StudentListForm studentListForm);
	
	// 페이지, 과별 학생조회
	public List<Student> selectByDepartmentId(StudentListForm studentListForm);
	
	// 학번으로 학생 조회
	public List<Student> selectByStudentId(StudentListForm studentListForm);
	
	// 페이징 처리 위한 전체 학생 수 조회
	public Integer selectStudentAmount();
	
	// 페이징 처리 위한 과 학생 수 조회
	public Integer selectStudentAmountByDeptId(Integer deptId);
	
	// 학생 grade, semester 업데이트
	public int updateStudentGradeAndSemester1_2();
	public int updateStudentGradeAndSemester2_1();
	public int updateStudentGradeAndSemester2_2();
	public int updateStudentGradeAndSemester3_1();
	public int updateStudentGradeAndSemester3_2();
	public int updateStudentGradeAndSemester4_1();
	public int updateStudentGradeAndSemester4_2();
	
	
	
}
