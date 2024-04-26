package com.green.university.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.university.dto.ChangePasswordDto;
import com.green.university.dto.FindIdFormDto;
import com.green.university.dto.FindPasswordFormDto;
import com.green.university.dto.LoginDto;
import com.green.university.dto.NoticeFormDto;
import com.green.university.dto.UserUpdateDto;
import com.green.university.dto.response.PrincipalDto;
import com.green.university.dto.response.ProfessorInfoDto;
import com.green.university.dto.response.StudentInfoDto;
import com.green.university.dto.response.StudentInfoStatListDto;
import com.green.university.dto.response.UserInfoForUpdateDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.repository.model.BreakApp;
import com.green.university.repository.model.Schedule;
import com.green.university.repository.model.Staff;
import com.green.university.repository.model.StuStat;
import com.green.university.service.BreakAppService;
import com.green.university.service.NoticeService;
import com.green.university.service.ScheuleService;
import com.green.university.service.StuStatService;
import com.green.university.service.UserService;
import com.green.university.utils.Define;

/**
 * User 로그인, 정보수정
 * 
 * @author 김지현
 */
@Controller
public class PersonalController {

	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private StuStatService stuStatService;
	@Autowired
	private BreakAppService breakAppService;
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private ScheuleService scheuleService;
	
	/**
	 * @author 서영 메인 홈페이지
	 */
	@GetMapping("")
	public String home(Model model) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);

		// 공지사항 최신 글 5개
		List<NoticeFormDto> noticeList = noticeService.readCurrentNotice();
		model.addAttribute("noticeList", noticeList);
		
		// 학사일정
		// 샘플이므로, 2월달로 고정함
		List<Schedule> scheduleList = scheuleService.readScheduleListByMonth(2);
		model.addAttribute("scheduleList", scheduleList);
		
		if (principal.getUserRole().equals("student")) {
			StudentInfoDto studentInfo = userService.readStudentInfo(principal.getId());
			StuStat stuStat = stuStatService.readCurrentStatus(principal.getId());
			model.addAttribute("userInfo", studentInfo);
			model.addAttribute("currentStatus", stuStat.getStatus());
		} else if (principal.getUserRole().equals("staff")) {
			Staff staffInfo = userService.readStaff(principal.getId());
			model.addAttribute("userInfo", staffInfo);

			List<BreakApp> breakAppList = breakAppService.readByStatus("처리중");
			model.addAttribute("breakAppSize", breakAppList.size());

		} else {
			ProfessorInfoDto professorInfo = userService.readProfessorInfo(principal.getId());
			model.addAttribute("userInfo", professorInfo);
		}

		return "/main";
	}

	/**
	 * 로그인 폼
	 * 
	 * @return login.jsp
	 */
	@GetMapping("/login")
	public String login() {

		return "/user/login";
	}

	/*
	 * 로그인 post 처리
	 * 
	 * @param loginDto
	 * 
	 * @return 메인 페이지 이동(수정 예정)
	 */
	@PostMapping("/login")
	public String signInProc(@Valid LoginDto loginDto, BindingResult bindingResult, HttpServletResponse response,
			HttpServletRequest request) {

		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				sb.append(error.getDefaultMessage()).append("\\n");
			});
			throw new CustomRestfullException(sb.toString(), HttpStatus.BAD_REQUEST);
		}

		PrincipalDto principal = userService.login(loginDto);
		if ("on".equals(loginDto.getRememberId())) {
			Cookie cookie = new Cookie("id", loginDto.getId() + "");
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);
		} else {
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if (c.getName().equals("id")) {
						c.setMaxAge(0);
						response.addCookie(c);
						break;
					}
				}
			}
		}
		session.setAttribute(Define.PRINCIPAL, principal);

		return "redirect:/";
	}

	/**
	 * 개인정보 수정 페이지
	 * 
	 * @param model
	 * @return updateUser.jsp
	 */
	@GetMapping("/update")
	public String updateUser(Model model) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		UserInfoForUpdateDto userInfoForUpdateDto = null;
		if ("staff".equals(principal.getUserRole())) {
			userInfoForUpdateDto = userService.readStaffInfoForUpdate(principal.getId());
		}
		if ("student".equals(principal.getUserRole())) {
			userInfoForUpdateDto = userService.readStudentInfoForUpdate(principal.getId());
		}
		if ("professor".equals(principal.getUserRole())) {
			userInfoForUpdateDto = userService.readProfessorInfoForUpdate(principal.getId());
		}
		model.addAttribute("userInfo", userInfoForUpdateDto);

		return "/user/updateUser";
	}

	/**
	 * 개인정보 수정 페이지
	 * 
	 * @param userInfoForUpdateDto, password
	 * @return updateUser.jsp
	 */
	@PutMapping("/update")
	public String updateUserProc(@Valid UserInfoForUpdateDto userInfoForUpdateDto, BindingResult bindingResult,
			@RequestParam String password) {

		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				sb.append(error.getDefaultMessage()).append("\\n");
			});
			throw new CustomRestfullException(sb.toString(), HttpStatus.BAD_REQUEST);
		}

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		// 패스워드 인코더 적용 후
		if (!passwordEncoder.matches(password, principal.getPassword())) {
			throw new CustomRestfullException(Define.WRONG_PASSWORD, HttpStatus.BAD_REQUEST);
		}

		UserUpdateDto updateDto = new UserUpdateDto();
		updateDto.setUserId(principal.getId());
		updateDto.setAddress(userInfoForUpdateDto.getAddress());
		updateDto.setEmail(userInfoForUpdateDto.getEmail());
		updateDto.setTel(userInfoForUpdateDto.getTel());
		if ("staff".equals(principal.getUserRole())) {
			userService.updateStaff(updateDto);
			return "redirect:/info/staff";
		}
		if ("student".equals(principal.getUserRole())) {
			userService.updateStudent(updateDto);
			return "redirect:/info/student";
		}
		if ("professor".equals(principal.getUserRole())) {
			userService.updateProfessor(updateDto);
			return "redirect:/info/professor";
		}

		return "redirect:/";
	}

	/**
	 * 비밀번호 수정 페이지
	 * 
	 * @param model
	 * @return updatePasword.jsp
	 */
	@GetMapping("/password")
	public String updatePassword() {

		return "/user/updatePassword";
	}

	/**
	 * 비밀번호 수정 post 페이지
	 * 
	 * @param userInfoForUpdateDto, password
	 * @return updateUser.jsp
	 */
	@PutMapping("/password")
	public String updatePasswordProc(@Valid ChangePasswordDto changePasswordDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				sb.append(error.getDefaultMessage()).append("\\n");
			});
			throw new CustomRestfullException(sb.toString(), HttpStatus.BAD_REQUEST);
		}

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		// 패스워드 인코더 적용 후
		if (!passwordEncoder.matches(changePasswordDto.getBeforePassword(), principal.getPassword())) {
			throw new CustomRestfullException(Define.WRONG_PASSWORD, HttpStatus.BAD_REQUEST);
		}
		if (!changePasswordDto.getAfterPassword().equals(changePasswordDto.getPasswordCheck())) {
			throw new CustomRestfullException("변경할 비밀번호와 비밀번호 확인은 같아야합니다.", HttpStatus.BAD_REQUEST);
		}
		changePasswordDto.setId(principal.getId());
		changePasswordDto.setAfterPassword(passwordEncoder.encode(changePasswordDto.getAfterPassword()));
		userService.updatePassword(changePasswordDto);

		return "redirect:/password";
	}

	/**
	 * 로그아웃
	 * 
	 * @return 로그인 페이지
	 */
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();

		return "redirect:/login";
	}

	/**
	 * 학생 정보 조회
	 * 
	 * @param model
	 * @return 학생 정보 조회 페이지
	 */
	@GetMapping("/info/student")
	public String readStudentInfo(Model model) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		StudentInfoDto student = userService.readStudentInfo(principal.getId());
		model.addAttribute("student", student);
		List<StudentInfoStatListDto> list = userService.readStudentInfoStatListByStudentId(principal.getId());
		model.addAttribute("stustatList", list);

		return "/user/studentInfo";
	}

	/**
	 * 직원 정보 조회
	 * 
	 * @param model
	 * @return 직원 정보조회 페이지
	 */
	@GetMapping("/info/staff")
	public String readStaffInfo(Model model) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		Staff staff = userService.readStaff(principal.getId());
		model.addAttribute("staff", staff);

		return "/user/staffInfo";
	}

	/**
	 * 교수 정보 조회
	 * 
	 * @param model
	 * @return 교수 정보 조회 페이지
	 */
	@GetMapping("/info/professor")
	public String readProfessorInfo(Model model) {
		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		ProfessorInfoDto professor = userService.readProfessorInfo(principal.getId());
		model.addAttribute("professor", professor);
		return "/user/professorInfo";
	}

	/**
	 * 아이디 찾기
	 * 
	 * @return 아이디 찾기 페이지
	 */
	@GetMapping("/find/id")
	public String findId() {

		return "/user/findId";
	}

	/**
	 * 아이디 찾기 포스트
	 * 
	 * @param findIdFormDto
	 * @return 찾은 아이디 표시 페이지
	 */
	@PostMapping("/find/id")
	public String findIdProc(Model model, @Valid FindIdFormDto findIdFormDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				sb.append(error.getDefaultMessage()).append("\\n");
			});
			throw new CustomRestfullException(sb.toString(), HttpStatus.BAD_REQUEST);
		}
		Integer findId = userService.readIdByNameAndEmail(findIdFormDto);
		model.addAttribute("id", findId);
		model.addAttribute("name", findIdFormDto.getName());

		return "/user/findIdComplete";
	}

	/**
	 * 비밀번호 찾기
	 * 
	 * @return 아이디 찾기 페이지
	 */
	@GetMapping("/find/password")
	public String findPassword() {

		return "/user/findPassword";
	}

	/**
	 * 비밀번호 찾기 포스트
	 * 
	 * @param findIdFormDto
	 * @return 비밀번호 표시 페이지
	 */
	@PostMapping("/find/password")
	public String findPasswordProc(Model model, @Valid FindPasswordFormDto findPasswordFormDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuilder sb = new StringBuilder();
			bindingResult.getAllErrors().forEach(error -> {
				sb.append(error.getDefaultMessage()).append("\\n");
			});
			throw new CustomRestfullException(sb.toString(), HttpStatus.BAD_REQUEST);
		}
		String password = userService.updateTempPassword(findPasswordFormDto);
		model.addAttribute("name", findPasswordFormDto.getName());
		model.addAttribute("password", password);

		return "/user/findPasswordComplete";
	}

	@GetMapping("/guide")
	public String pop() {

		return "/user/passwordPop";
	}

	/**
	 * @return 에러페이지
	 */
	@GetMapping("/error")
	public String handleError() {
		return "/error/errorPage";
	}
}
