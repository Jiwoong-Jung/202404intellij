package com.green.university.repository.interfaces;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.green.university.dto.AllSubjectSearchFormDto;
import com.green.university.dto.CurrentSemesterSubjectSearchFormDto;
import com.green.university.dto.SubjectFormDto;
import com.green.university.dto.response.ReadSyllabusDto;
import com.green.university.dto.response.SubjectDto;
import com.green.university.dto.response.SubjectForProfessorDto;
import com.green.university.dto.response.SubjectPeriodForProfessorDto;
import com.green.university.repository.model.Subject;

/*
 *  박성희
 *  강의 repository
 */

@Mapper
public interface SubjectRepository {
	// 과목 insert
	public Integer insert(SubjectFormDto subjectFormDto);
	public int deleteById(Integer id);
	public int updateBySubjectDto(SubjectFormDto subjectFormDto);
	
	/**
	 * 성희 
	 * 강의 입력 시 같은 강의실, 요일, 연도, 학기 정보 조회
	 */
	public List<Subject> selectByRoomIdAndSubDayAndSubYearAndSemester(SubjectFormDto subjectFormDto);
	
	/**
	 * 성희 
	 * 제일 최근 강의 ID 조회
	 */
	public Integer selectIdOrderById(SubjectFormDto subjectFormDto);
	
	/**
	 * @author 서영
	 * @return 수강 신청에 사용할 강의 정보
	 */
	public List<SubjectDto> selectDtoBySemester(@Param("subYear") Integer subYear, @Param("semester") Integer semester);
	public List<SubjectDto> selectDtoBySemesterLimit(@Param("subYear") Integer subYear, @Param("semester") Integer semester, @Param("page") Integer page);
	
	/**
	 * @author 서영
	 * @return 전체 강의 정보
	 */
	public List<SubjectDto> selectDtoAll();
	public List<SubjectDto> selectDtoAllLimit(Integer page);
	
	/**
	 * @author 김지현
	 * @param 교수 id
	 * @return 교수 본인의 수업이 있는 년도-학기
	 */
	public List<SubjectPeriodForProfessorDto> selectSemester(Integer id);
	
	/**
	 * @author 김지현
	 * @return 그 학기의 본인 수업 정보들
	 */
	public List<SubjectForProfessorDto> selectSubjectBySemester(SubjectPeriodForProfessorDto subjectPeriodForProfessorDto);
	
	/**
	 * @author 서영
	 * @return 연도-학기-개설학과-강의명 검색을 조건으로 한 강의 정보
	 */
	public List<SubjectDto> selectDtoBySemesterAndDeptAndName(AllSubjectSearchFormDto allSubjectSearchFormDto);
	
	/**
	 * @param currentSemesterSubjectSearchFormDto
	 * @return 연도-학기-강의구분-개설학과-강의명 검색을 조건으로 한 강의 정보
	 */
	public List<SubjectDto> selectDtoBySemesterAndAndTypeAndDeptAndName(CurrentSemesterSubjectSearchFormDto currentSemesterSubjectSearchFormDto);
	
	/*
	 * @author 김지현
	 * @param id
	 * @return
	 */
	public Subject selectSubjectById(Integer id);
	
	public List<Subject> selectAll();

	/**
	 * @author 서영
	 * 현재 인원 수정 (1명 추가 or 삭제 or 0으로 초기화)
	 */
	public int updateNumOfStudent(@Param("id") Integer id, @Param("type") String type);
	
	
	public ReadSyllabusDto selectSyllabusBySubjectId(Integer subjectId);
	
	/**
	 * @author 서영
	 * 정원 >= 신청인원인 강의의 id 리스트
	 */
	public List<Integer> selectIdByLessNumOfStudent();
	
	/**
	 * @author 서영
	 * 정원 < 신청인원인 강의의 id 리스트
	 */
	public List<Integer> selectIdByMoreNumOfStudent();
	
	
	
}
