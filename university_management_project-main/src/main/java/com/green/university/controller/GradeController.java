package com.green.university.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.university.dto.response.GradeDto;
import com.green.university.dto.response.MyGradeDto;
import com.green.university.dto.response.PrincipalDto;
import com.green.university.service.GradeService;
import com.green.university.utils.Define;

/**
 * 
 * @author 편용림
 * 
 *         금학기,학기별 성적, 누계성적 조회
 * 
 */

@Controller
@RequestMapping("/grade")
public class GradeController {

	@Autowired
	private HttpSession session;

	@Autowired
	private GradeService gradeService;

	/**
	 * 금학기 성적조회
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/thisSemester")
	public String thisSemester(Model model) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);

		// 학생이 수강 신청한 연도 조회
		List<GradeDto> yearList = gradeService.readGradeYearByStudentId(principal.getId());
		model.addAttribute("yearList", yearList);

		// 수강한 연도가 없으면 금학기 성적조회 x
		if (yearList.size() != 0) {

			// 금학기 성적조회 기능
			List<GradeDto> thisSemester = gradeService.readThisSemesterByStudentId(principal.getId());
			model.addAttribute("gradeList", thisSemester);

			// 누계 성적 조회
			MyGradeDto mygrade = gradeService.readMyGradeByStudentId(principal.getId());
			model.addAttribute("mygrade", mygrade);

		}

		return "grade/thisgrade";
	}

	/**
	 * 학기별 성적조회
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/semester")
	public String semester(Model model) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);

		// 학생이 수강 신청한 연도 조회
		List<GradeDto> yearList = gradeService.readGradeYearByStudentId(principal.getId());
		// 전체 성적 조회
		List<GradeDto> gradeAllList = gradeService.readAllGradeByStudentId(principal.getId());
		// 학생이 신청한 학기가 있는지 찾는 기능
		List<GradeDto> semesterList = gradeService.readGradeSemesterByStudentId(principal.getId());

		model.addAttribute("yearList", yearList);
		model.addAttribute("gradeList", gradeAllList);
		model.addAttribute("semesterList", semesterList);

		return "grade/semester";
	}

	/**
	 * 학기별 성적 조회
	 * 
	 * @param model
	 * @param httpServletRequest
	 * @return
	 */
	@PostMapping("/read")
	public String readGradeProc(Model model, HttpServletRequest httpServletRequest) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);

		// 학생이 수강 신청한 연도 조회
		List<GradeDto> yearList = gradeService.readGradeYearByStudentId(principal.getId());

		// 학생이 수강 신청한 학기 조회
		List<GradeDto> semesterList = gradeService.readGradeSemesterByStudentId(principal.getId());

		// 조회 할때 값을 들고옴
		String type = httpServletRequest.getParameter("type");
		int subYear = Integer.parseInt(httpServletRequest.getParameter("subYear"));
		int sesmeter = Integer.parseInt(httpServletRequest.getParameter("sesmeter"));

		if (type.equals("전체")) {
			List<GradeDto> gradeAllList = gradeService.readGradeByStudentId(principal.getId(), subYear, sesmeter);
			model.addAttribute("gradeList", gradeAllList);
		} else {
			List<GradeDto> gradeList = gradeService.readGradeByType(principal.getId(), subYear, sesmeter, type);
			model.addAttribute("gradeList", gradeList);
		}

		model.addAttribute("yearList", yearList);
		model.addAttribute("semesterList", semesterList);

		return "grade/semester";
	};

	/**
	 * 총 누계성적
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("total")
	public String totalGrade(Model model) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);

		// 학생이 수강 신청한 연도 조회
		List<GradeDto> yearList = gradeService.readGradeYearByStudentId(principal.getId());
		List<MyGradeDto> mygradeList = gradeService.readgradeinquiryList(principal.getId());

		model.addAttribute("yearList", yearList);
		model.addAttribute("mygradeList", mygradeList);

		return "grade/totalgrade";
	}

}
