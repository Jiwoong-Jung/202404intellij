package com.green.university.dto.response;

import lombok.Data;

/**
 * 강의계획서 조회용 dto
 * @author 김지현
 */
@Data
public class ReadSyllabusDto {

//	sy.subject_id, s.name, s.sub_year, s.semester, s.grades, s.type, s.sub_day, s.start_time, s.end_time, s.room_id, 
//	c.name college_name, p.name as professer_name, d.name as dept_name, p.tel, p.email, sy.overview, sy.objective, sy.textbook, sy.program
	
	private Integer subjectId;
	private String name;
	private String subYear;
	private String semester;
	// 학점
	private Integer grades;
	private String type;
	// 요일
	private String subDay;
	private Integer startTime;
	private Integer endTime;
	private String roomId;
	private String collegeName;
	private String professorName;
	private String deptName;
	private String tel;
	private String email;
	private String overview;
	private String objective;
	private String textbook;
	private String program;
	
	
}
