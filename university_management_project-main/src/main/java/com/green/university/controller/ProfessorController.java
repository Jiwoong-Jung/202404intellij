package com.green.university.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.university.dto.SyllaBusFormDto;
import com.green.university.dto.UpdateStudentGradeDto;
import com.green.university.dto.response.PrincipalDto;
import com.green.university.dto.response.ReadSyllabusDto;
import com.green.university.dto.response.StudentInfoForProfessorDto;
import com.green.university.dto.response.SubjectForProfessorDto;
import com.green.university.dto.response.SubjectPeriodForProfessorDto;
import com.green.university.repository.model.Student;
import com.green.university.repository.model.Subject;
import com.green.university.service.ProfessorService;
import com.green.university.service.StuSubService;
import com.green.university.service.SubjectService;
import com.green.university.service.UserService;
import com.green.university.utils.Define;

/**
 * 교수 행정 페이지 (자기과목 조회, 학생 성적 기입)
 * 
 * @author 김지현
 */
@Controller
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;
	@Autowired
	private HttpSession session;
	@Autowired
	private UserService userService;
	@Autowired
	private StuSubService stuSubService;
	@Autowired
	private SubjectService subjectService;
	
	/**
	 * 본인의 강의가 있는 년도 학기 조회하는 기능 조회한 년도 학기의 강의 리스트 출력(처음값은 현재학기)
	 * 
	 * @param model
	 * @return 본인 강좌 조회 페이지
	 */
	@GetMapping("/subject")
	public String subjectList(Model model) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		List<SubjectPeriodForProfessorDto> semesterList = professorService.selectSemester(principal.getId());
		SubjectPeriodForProfessorDto subjectPeriodForProfessorDto = new SubjectPeriodForProfessorDto();
		subjectPeriodForProfessorDto.setSubYear(Define.CURRENT_YEAR);
		subjectPeriodForProfessorDto.setSemester(Define.CURRENT_SEMESTER);
		subjectPeriodForProfessorDto.setId(principal.getId());
		List<SubjectForProfessorDto> subjectList = professorService
				.selectSubjectBySemester(subjectPeriodForProfessorDto);
		model.addAttribute("semesterList", semesterList);
		model.addAttribute("subjectList", subjectList);

		return "/professor/professorSubjectList";
	}

	/**
	 * 조회한 년도 학기의 강의 리스트 출력
	 * 
	 * @param model
	 * @param period: 조회할 년도 학기
	 * @return 조회 신청한 학기의 본인 강좌 조회 페이지
	 */
	@PostMapping("/subject")
	public String subjectListProc(Model model, @RequestParam String period) {
		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		List<SubjectPeriodForProfessorDto> semesterList = professorService.selectSemester(principal.getId());
		String[] strs = period.split("year");
		SubjectPeriodForProfessorDto subjectPeriodForProfessorDto = new SubjectPeriodForProfessorDto();
		subjectPeriodForProfessorDto.setSubYear(Integer.parseInt(strs[0]));
		subjectPeriodForProfessorDto.setSemester(Integer.parseInt(strs[1]));
		subjectPeriodForProfessorDto.setId(principal.getId());
		List<SubjectForProfessorDto> subjectList = professorService.selectSubjectBySemester(subjectPeriodForProfessorDto);
		model.addAttribute("semesterList", semesterList);
		model.addAttribute("subjectList", subjectList);

		return "/professor/professorSubjectList";
	}

	/**
	 * 
	 * @param model
	 * @return 해당 과목을 듣는 학생 리스트
	 */
	@GetMapping("/subject/{subjectId}")
	public String subjectStudentList(Model model, @PathVariable Integer subjectId) {
		List<StudentInfoForProfessorDto> studentList = professorService.selectBySubjectId(subjectId);
		Subject subject = professorService.selectSubjectById(subjectId);

		model.addAttribute("studentList", studentList);
		model.addAttribute("subject", subject);

		return "/professor/subjectStudentList";
	}

	/**
	 * 
	 * @param model
	 * @param subjectId
	 * @param studentId
	 * @return 출결 및 성적 기입 페이지
	 */
	@GetMapping("/subject/{subjectId}/{studentId}")
	public String updateStudentDetail(Model model, @PathVariable Integer subjectId, @PathVariable Integer studentId) {

		Student student = userService.readStudent(studentId);
		model.addAttribute("student", student);
		model.addAttribute("subjectId", subjectId);

		return "/professor/updateStudentDetail";
	}

	@PutMapping("/subject/{subjectId}/{studentId}")
	public String updateStudentDetailProc(Model model, @PathVariable Integer subjectId, @PathVariable Integer studentId,
			UpdateStudentGradeDto updateStudentGradeDto) {

		// 점수 입력
		professorService.updateGrade(updateStudentGradeDto);
		
		// 취득학점 입력
		if (updateStudentGradeDto.getGrade().equals("F")) {
			stuSubService.updateCompleteGrade(studentId, subjectId, 0);
		} else {
			Integer subjectGrade = subjectService.readBySubjectId(subjectId).getGrades();
			stuSubService.updateCompleteGrade(studentId, subjectId, subjectGrade);
		}
		
		return "redirect:/professor/subject/ " + subjectId;
	}

	/**
	 * 
	 * @param model
	 * @return 강의계획서 업데이트 창
	 */
	@GetMapping("/syllabus/update/{subjectId}")
	public String createSyllabus(Model model, @PathVariable Integer subjectId) {
		ReadSyllabusDto readSyllabusDto = professorService.readSyllabus(subjectId);

		model.addAttribute("syllabus", readSyllabusDto);

		return "/professor/updateSyllabus";
	}

	/**
	 * 
	 * @param syllaBusFormDto
	 * @return 강의계획서창
	 */
	@PutMapping("/syllabus/update/{subjectId}")
	public String createSyllabusProc(SyllaBusFormDto syllaBusFormDto) {
		System.out.println(syllaBusFormDto);
		professorService.updateSyllabus(syllaBusFormDto);

		return "redirect:/subject/syllabus/" + syllaBusFormDto.getSubjectId();
	}

}
