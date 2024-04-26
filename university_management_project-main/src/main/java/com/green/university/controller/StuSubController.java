package com.green.university.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.university.dto.CurrentSemesterSubjectSearchFormDto;
import com.green.university.dto.response.PrincipalDto;
import com.green.university.dto.response.StuSubAppDto;
import com.green.university.dto.response.SubjectDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.model.BreakApp;
import com.green.university.repository.model.Department;
import com.green.university.repository.model.PreStuSub;
import com.green.university.repository.model.StuStat;
import com.green.university.repository.model.StuSub;
import com.green.university.repository.model.Student;
import com.green.university.service.BreakAppService;
import com.green.university.service.CollegeService;
import com.green.university.service.PreStuSubService;
import com.green.university.service.StuStatService;
import com.green.university.service.StuSubService;
import com.green.university.service.SubjectService;
import com.green.university.service.UserService;
import com.green.university.utils.Define;
import com.green.university.utils.StuStatUtil;

/**
 * @author 서영 
 * 수강 신청 관련 (preStuSub 포함) 강의 시간표는 SubjectController 대신 일부러 여기에 넣음
 */

@Controller
@RequestMapping("/sugang")
public class StuSubController {

	@Autowired
	private HttpSession session;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private CollegeService collegeService;

	@Autowired
	private PreStuSubService preStuSubService;

	@Autowired
	private StuSubService stuSubService;

	@Autowired
	private StuStatService stuStatService;

	@Autowired
	private BreakAppService breakAppService;

	@Autowired
	private UserService userService;

	// 예비 수강신청 기간 : 0, 수강신청 기간 : 1, 수강신청 기간 종료 : 2
	public static int SUGANG_PERIOD = 0;

	// 예비 수강신청 기간에서 수강신청 기간으로 변경하는 페이지 (교직원용)
	@GetMapping("/period")
	public String updatePeriod() {

		return "/stuSub/updatePeriod";
	}

	// 예비 수강 신청 기간 -> 수강 신청 기간
	@GetMapping("/updatePeriod1")
	public String updatePeriodProc1() {
		SUGANG_PERIOD = 1;

		stuSubService.createStuSubByPreStuSub();

		return "/stuSub/updatePeriod";
	}

	// 수강 신청 기간 -> 종료
	@GetMapping("/updatePeriod2")
	public String updatePeriodProc2() {
		SUGANG_PERIOD = 2;

		return "/stuSub/updatePeriod";
	}

	// 과목 조회 (현재 학기)
	@GetMapping("/subjectList/{page}")
	public String readSubjectList(Model model, @PathVariable Integer page) {

		// 강의 리스트
		List<SubjectDto> subjectList = subjectService.readSubjectListByCurrentSemester();

		int subjectCount = subjectList.size();
		model.addAttribute("subjectCount", subjectCount);
		// 총 페이지 수
		int pageCount = (int) Math.ceil(subjectCount / 20.0);
		model.addAttribute("pageCount", pageCount);
		// 현재 페이지
		model.addAttribute("page", page);

		List<SubjectDto> subjectListLimit = subjectService.readSubjectListByCurrentSemesterPage((page - 1) * 20);
		model.addAttribute("subjectList", subjectListLimit);

		// 필터에 사용할 전체 학과 정보
		List<Department> deptList = collegeService.readDeptAll();
		model.addAttribute("deptList", deptList);

		// 필터에 사용할 강의 이름 정보 (중복 값 제거)
		List<String> subNameList = new ArrayList<>();
		for (SubjectDto subject : subjectList) {
			if (subNameList.contains(subject.getName()) == false) {
				subNameList.add(subject.getName());
			}
		}
		model.addAttribute("subNameList", subNameList);

		return "/stuSub/subList";
	}

	// 과목 조회 (현재 학기)에서 필터링
	@GetMapping("/subjectList/search")
	public String readSubjectListSearch(Model model,
			@Validated CurrentSemesterSubjectSearchFormDto currentSemesterSubjectSearchFormDto) {

		// 강의 리스트
		List<SubjectDto> subjectList = subjectService
				.readSubjectListSearchByCurrentSemester(currentSemesterSubjectSearchFormDto);
		model.addAttribute("subjectList", subjectList);

		int subjectCount = subjectList.size();
		model.addAttribute("subjectCount", subjectCount);

		// 필터에 사용할 전체 학과 정보
		List<Department> deptList = collegeService.readDeptAll();
		model.addAttribute("deptList", deptList);

		// 필터에 사용할 강의 이름 정보 (중복 값 제거)
		List<String> subNameList = new ArrayList<>();
		for (SubjectDto subject : subjectService.readSubjectListByCurrentSemester()) {
			if (subNameList.contains(subject.getName()) == false) {
				subNameList.add(subject.getName());
			}
		}
		model.addAttribute("subNameList", subNameList);

		return "/stuSub/subList";
	}

	/**
	 * @return 예비 수강 신청
	 */
	@GetMapping("/pre/{page}")
	public String preStuSubApplication(Model model, @PathVariable Integer page) {

		// 예비 수강 신청 기간이 아니라면
		if (SUGANG_PERIOD != 0) {
			throw new CustomRestfullException("예비 수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
		}

		// 이번 학기에 재학 상태가 되지 않는 학생이라면 진입 불가
		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		Student studentInfo = userService.readStudent(principal.getId());

		StuStat stuStatEntity = stuStatService.readCurrentStatus(studentInfo.getId());
		List<BreakApp> breakAppList = breakAppService.readByStudentId(studentInfo.getId()); // 최근 순으로 정렬되어 있음

		StuStatUtil.checkStuStat("수강신청", stuStatEntity, breakAppList);

		// 강의 리스트
		List<SubjectDto> subjectList = subjectService.readSubjectListByCurrentSemester();

		int subjectCount = subjectList.size();
		model.addAttribute("subjectCount", subjectCount);
		// 총 페이지 수
		int pageCount = (int) Math.ceil(subjectCount / 20.0);
		model.addAttribute("pageCount", pageCount);
		// 현재 페이지
		model.addAttribute("page", page);

		List<SubjectDto> subjectListLimit = subjectService.readSubjectListByCurrentSemesterPage((page - 1) * 20);
		for (SubjectDto sub : subjectListLimit) {
			// 현재 담겨 있는지 확인
			PreStuSub preStuSub = preStuSubService.readPreStuSub(principal.getId(), sub.getId());
			if (preStuSub != null) {
				sub.setStatus(true);
			} else {
				sub.setStatus(false);
			}
		}
		model.addAttribute("subjectList", subjectListLimit);

		// 필터에 사용할 전체 학과 정보
		List<Department> deptList = collegeService.readDeptAll();
		model.addAttribute("deptList", deptList);

		// 필터에 사용할 강의 이름 정보 (중복 값 제거)
		List<String> subNameList = new ArrayList<>();
		for (SubjectDto subject : subjectList) {
			if (subNameList.contains(subject.getName()) == false) {
				subNameList.add(subject.getName());
			}
		}
		model.addAttribute("subNameList", subNameList);

		return "/stuSub/preApplication";
	}

	/**
	 * 예비 수강 신청 처리 (신청)
	 */

	@PostMapping("/pre/{subjectId}")
	public String insertPreStuSubAppProc(@PathVariable Integer subjectId) {

		// 예비 수강 신청 기간이 아니라면
		if (SUGANG_PERIOD != 0) {
			throw new CustomRestfullException("예비 수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
		}

		Integer studentId = ((PrincipalDto) session.getAttribute(Define.PRINCIPAL)).getId();
		preStuSubService.createPreStuSub(studentId, subjectId);

		// 강의 검색 페이지에서 신청 시
		return "redirect:/sugang/pre/1";
	}

	/**
	 * 예비 수강 신청 처리 (취소)
	 */

	@DeleteMapping("/pre/{subjectId}")
	public String deletePreStuSubAppProc(@PathVariable Integer subjectId, @RequestParam Integer type) {

		// 예비 수강 신청 기간이 아니라면
		if (SUGANG_PERIOD != 0) {
			throw new CustomRestfullException("예비 수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
		}

		Integer studentId = ((PrincipalDto) session.getAttribute(Define.PRINCIPAL)).getId();
		preStuSubService.deletePreStuSub(studentId, subjectId);

		// 강의 검색 페이지에서 취소 시
		if (type == 0) {
			return "redirect:/sugang/pre/1";
			// 수강 신청 내역 페이지에서 취소 시
		} else {
			return "redirect:/sugang/preAppList?type=0";
		}
	}

	// 예비 수강 신청 강의 목록에서 필터링
	@GetMapping("/pre/search")
	public String preStuSubApplicationSearch(Model model,
			@Validated CurrentSemesterSubjectSearchFormDto currentSemesterSubjectSearchFormDto) {

		// 예비 수강 신청 기간이 아니라면
		if (SUGANG_PERIOD != 0) {
			throw new CustomRestfullException("예비 수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
		}

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);

		// 강의 리스트
		List<SubjectDto> subjectList = subjectService
				.readSubjectListSearchByCurrentSemester(currentSemesterSubjectSearchFormDto);

		for (SubjectDto sub : subjectList) {
			// 현재 담겨 있는지 확인
			PreStuSub preStuSub = preStuSubService.readPreStuSub(principal.getId(), sub.getId());
			if (preStuSub != null) {
				sub.setStatus(true);
			} else {
				sub.setStatus(false);
			}
		}

		int subjectCount = subjectList.size();
		model.addAttribute("subjectCount", subjectCount);
		model.addAttribute("subjectList", subjectList);

		// 필터에 사용할 전체 학과 정보
		List<Department> deptList = collegeService.readDeptAll();
		model.addAttribute("deptList", deptList);

		// 필터에 사용할 강의 이름 정보 (중복 값 제거)
		List<String> subNameList = new ArrayList<>();
		for (SubjectDto subject : subjectService.readSubjectListByCurrentSemester()) {
			if (subNameList.contains(subject.getName()) == false) {
				subNameList.add(subject.getName());
			}
		}
		model.addAttribute("subNameList", subNameList);

		return "/stuSub/preApplication";
	}

	/**
	 * @return 수강 신청
	 */
	@GetMapping("/application/{page}")
	public String stuSubApplication(Model model, @PathVariable Integer page) {

		// 수강 신청 기간이 아니라면
		if (SUGANG_PERIOD != 1) {
			throw new CustomRestfullException("수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
		}

		// 이번 학기에 재학 상태가 되지 않는 학생이라면 진입 불가
		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		Student studentInfo = userService.readStudent(principal.getId());

		StuStat stuStatEntity = stuStatService.readCurrentStatus(studentInfo.getId());
		List<BreakApp> breakAppList = breakAppService.readByStudentId(studentInfo.getId()); // 최근 순으로 정렬되어 있음
		StuStatUtil.checkStuStat("수강신청", stuStatEntity, breakAppList);

		// 강의 리스트
		List<SubjectDto> subjectList = subjectService.readSubjectListByCurrentSemester();

		int subjectCount = subjectList.size();
		model.addAttribute("subjectCount", subjectCount);
		// 총 페이지 수
		int pageCount = (int) Math.ceil(subjectCount / 20.0);
		model.addAttribute("pageCount", pageCount);
		// 현재 페이지
		model.addAttribute("page", page);

		List<SubjectDto> subjectListLimit = subjectService.readSubjectListByCurrentSemesterPage((page - 1) * 20);
		for (SubjectDto sub : subjectListLimit) {
			// 현재 담겨 있는지 확인
			StuSub stuSub = stuSubService.readStuSub(principal.getId(), sub.getId());
			if (stuSub != null) {
				sub.setStatus(true);
			} else {
				sub.setStatus(false);
			}
		}
		model.addAttribute("subjectList", subjectListLimit);

		// 필터에 사용할 전체 학과 정보
		List<Department> deptList = collegeService.readDeptAll();
		model.addAttribute("deptList", deptList);

		// 필터에 사용할 강의 이름 정보 (중복 값 제거)
		List<String> subNameList = new ArrayList<>();
		for (SubjectDto subject : subjectList) {
			if (subNameList.contains(subject.getName()) == false) {
				subNameList.add(subject.getName());
			}
		}
		model.addAttribute("subNameList", subNameList);

		return "stuSub/application";
	}

	// 수강 신청 강의 목록에서 필터링
	@GetMapping("/application/search")
	public String stuSubApplicationSearch(Model model,
			@Validated CurrentSemesterSubjectSearchFormDto currentSemesterSubjectSearchFormDto) {

		// 수강 신청 기간이 아니라면
		if (SUGANG_PERIOD != 1) {
			throw new CustomRestfullException("수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
		}

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);

		// 강의 리스트
		List<SubjectDto> subjectList = subjectService
				.readSubjectListSearchByCurrentSemester(currentSemesterSubjectSearchFormDto);
		for (SubjectDto sub : subjectList) {
			// 현재 담겨 있는지 확인
			StuSub stuSub = stuSubService.readStuSub(principal.getId(), sub.getId());
			if (stuSub != null) {
				sub.setStatus(true);
			} else {
				sub.setStatus(false);
			}
		}

		int subjectCount = subjectList.size();
		model.addAttribute("subjectCount", subjectCount);
		model.addAttribute("subjectList", subjectList);

		// 필터에 사용할 전체 학과 정보
		List<Department> deptList = collegeService.readDeptAll();
		model.addAttribute("deptList", deptList);

		// 필터에 사용할 강의 이름 정보 (중복 값 제거)
		List<String> subNameList = new ArrayList<>();
		for (SubjectDto subject : subjectList) {
			if (subNameList.contains(subject.getName()) == false) {
				subNameList.add(subject.getName());
			}
		}
		model.addAttribute("subNameList", subNameList);

		return "/stuSub/application";
	}

	/**
	 * 수강 신청 처리 (신청)
	 */
	@PostMapping("/insertApp/{subjectId}")
	public String insertStuSubAppProc(@PathVariable Integer subjectId, @RequestParam Integer type) {

		// 수강 신청 기간이 아니라면
		if (SUGANG_PERIOD != 1) {
			throw new CustomRestfullException("수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
		}

		Integer studentId = ((PrincipalDto) session.getAttribute(Define.PRINCIPAL)).getId();
		stuSubService.createStuSub(studentId, subjectId);

		// 강의 검색 페이지에서 신청 시
		if (type == 0) {
			return "redirect:/sugang/application/1";
			// 예비 수강 신청 내역 페이지에서 신청 시
		} else {
			return "redirect:/sugang/preAppList?type=1";
		}
	}

	/**
	 * 수강 신청 처리 (취소)
	 */
	@DeleteMapping("/deleteApp/{subjectId}")
	public String deleteStuSubAppProc(@PathVariable Integer subjectId, @RequestParam Integer type) {

		// 수강 신청 기간이 아니라면
		if (SUGANG_PERIOD != 1) {
			throw new CustomRestfullException("수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
		}

		Integer studentId = ((PrincipalDto) session.getAttribute(Define.PRINCIPAL)).getId();
		stuSubService.deleteStuSub(studentId, subjectId);

		// 강의 검색 페이지에서 취소 시
		if (type == 0) {
			return "redirect:/sugang/application/1";
			// 예비 수강 신청 내역 페이지에서 취소 시
		} else {
			return "redirect:/sugang/preAppList?type=1";
		}
	}

	/**
	 * @return 예비 수강 신청 내역
	 */
	@GetMapping("/preAppList")
	public String preStuSubAppList(Model model, @RequestParam Integer type) {

		// 이번 학기에 재학 상태가 되지 않는 학생이라면 진입 불가
		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		Student studentInfo = userService.readStudent(principal.getId());

		StuStat stuStatEntity = stuStatService.readCurrentStatus(studentInfo.getId());
		List<BreakApp> breakAppList = breakAppService.readByStudentId(studentInfo.getId()); // 최근 순으로 정렬되어 있음
		StuStatUtil.checkStuStat("수강신청", stuStatEntity, breakAppList);

		model.addAttribute("type", type);

		// 예비 수강 신청 기간에 조회 시
		if (type == 0) {
			List<StuSubAppDto> preStuSubList = preStuSubService.readPreStuSubList(principal.getId());
			model.addAttribute("stuSubList", preStuSubList);

			int sumGrades = 0;
			for (StuSubAppDto s : preStuSubList) {
				sumGrades += s.getGrades();
			}
			model.addAttribute("sumGrades", sumGrades);

			return "/stuSub/preAppList";
		}

		// 수강 신청 기간에 조회 시 (예비 수강 신청 목록에서 수강 신청으로 자동으로 넘어간 강의와, 직접 신청해야 하는 강의를 분리해서 보여줄
		// 것)

		// 수강 신청 기간이 아니라면
		if (SUGANG_PERIOD != 1) {
			throw new CustomRestfullException("수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
		}

		// 수강 신청이 완료되지 않은 예비 수강 신청 내역
		List<StuSubAppDto> preStuSubList1 = stuSubService.readPreStuSubByStuSub(principal.getId());
		model.addAttribute("stuSubList", preStuSubList1);

		// 수강 신청 내역
		List<StuSubAppDto> stuSubList = stuSubService.readStuSubList(principal.getId());
		model.addAttribute("stuSubListC", stuSubList);

		int sumGrades = 0;
		for (StuSubAppDto s : stuSubList) {
			sumGrades += s.getGrades();
		}
		model.addAttribute("sumGrades", sumGrades);

		return "/stuSub/preAppList";
	}

	/**
	 * @return 수강 신청 내역
	 */
	@GetMapping("/list")
	public String stuSubAppList(Model model) {

		// 예비 수강 신청 기간이라면
		if (SUGANG_PERIOD == 0) {
			throw new CustomRestfullException("수강 신청 기간이 아닙니다.", HttpStatus.BAD_REQUEST);
		}

		// 이번 학기에 재학 상태가 되지 않는 학생이라면 진입 불가
		// 해당 학생의 학적 상태가 '졸업' 또는 '자퇴'라면 X
		// 해당 학생이 이번 학기 휴학을 승인받은 상태라면 X
		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		Student studentInfo = userService.readStudent(principal.getId());

		StuStat stuStatEntity = stuStatService.readCurrentStatus(studentInfo.getId());
		List<BreakApp> breakAppList = breakAppService.readByStudentId(studentInfo.getId()); // 최근 순으로 정렬되어 있음
		StuStatUtil.checkStuStat("수강신청", stuStatEntity, breakAppList);

		List<StuSubAppDto> stuSubList = stuSubService.readStuSubList(principal.getId());
		model.addAttribute("stuSubList", stuSubList);

		int sumGrades = 0;
		for (StuSubAppDto s : stuSubList) {
			sumGrades += s.getGrades();
		}
		model.addAttribute("sumGrades", sumGrades);

		return "/stuSub/appList";
	}

}
