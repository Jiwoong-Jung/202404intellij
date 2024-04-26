package com.green.university.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.university.dto.EvaluationDto;
import com.green.university.dto.MyEvaluationDto;
import com.green.university.dto.response.PrincipalDto;
import com.green.university.dto.response.QuestionDto;
import com.green.university.handler.exception.CustomRestfullException;
import com.green.university.service.EvaluationService;
import com.green.university.service.QuestionService;
import com.green.university.utils.Define;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {

	@Autowired
	private HttpSession session;
	@Autowired
	private EvaluationService evaluationService;
	@Autowired
	private QuestionService questionService;

	/**
	 * 편용림
	 * 
	 * @return 강의평가 화면 클릭
	 */
	@GetMapping("")
	public String evaluation(Model model, Integer subjectId) {

		QuestionDto dto = questionService.readQuestion();
		model.addAttribute("subjectId", subjectId);
		model.addAttribute("dto", dto);
		return "evaluation/evaluation";
	}

	/*
	 * 강의평가 post
	 */
	@PostMapping("/write/{subjectId}")
	public String EvaluationProc(@PathVariable Integer subjectId, EvaluationDto evaluationFormDto, Model model) {
		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);

		evaluationFormDto.setStudentId(principal.getId());
		evaluationFormDto.setSubjectId(subjectId);

		if (evaluationFormDto.getAnswer1() == null) {
			throw new CustomRestfullException("1번 질문에 답 해주세요", HttpStatus.BAD_REQUEST);
		} else if (evaluationFormDto.getAnswer2() == null) {
			throw new CustomRestfullException("2번 질문에 답 해주세요", HttpStatus.BAD_REQUEST);
		} else if (evaluationFormDto.getAnswer3() == null) {
			throw new CustomRestfullException("3번 질문에 답 해주세요", HttpStatus.BAD_REQUEST);
		} else if (evaluationFormDto.getAnswer4() == null) {
			throw new CustomRestfullException("4번 질문에 답 해주세요", HttpStatus.BAD_REQUEST);
		} else if (evaluationFormDto.getAnswer5() == null) {
			throw new CustomRestfullException("5번 질문에 답 해주세요", HttpStatus.BAD_REQUEST);
		} else if (evaluationFormDto.getAnswer6() == null) {
			throw new CustomRestfullException("6번 질문에 답 해주세요", HttpStatus.BAD_REQUEST);
		} else if (evaluationFormDto.getAnswer7() == null) {
			throw new CustomRestfullException("7번 질문에 답 해주세요", HttpStatus.BAD_REQUEST);
		} else {
			evaluationService.createEvanluation(evaluationFormDto);
		}

		// 창을 닫을 때 post가 작동이 안하는거 방지
		model.addAttribute("type", 1);
		return "evaluation/evaluation";
	}

	// 강의 평가 처음화면 (교수)
	@GetMapping("/read")
	public String readEvaluation(Model model) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);

		List<MyEvaluationDto> subjectName = evaluationService.readSubjectName(principal.getId());
		List<MyEvaluationDto> eval = evaluationService.readEvaluationByProfessorId(principal.getId());
		model.addAttribute("subjectName", subjectName);
		model.addAttribute("eval", eval);

		return "evaluation/myEvaluation";
	}

	// 과목별 강의 평가 조회 (교수)
	@PostMapping("/read")
	public String readEvaluation(Model model, HttpServletRequest httpServletRequest) {

		PrincipalDto principal = (PrincipalDto) session.getAttribute(Define.PRINCIPAL);
		String name = httpServletRequest.getParameter("subjectId");

		List<MyEvaluationDto> subjectName = evaluationService.readSubjectName(principal.getId());
		List<MyEvaluationDto> eval = evaluationService.readEvaluationByProfessorIdAndName(principal.getId(), name);
		model.addAttribute("subjectName", subjectName);
		model.addAttribute("eval", eval);
		return "evaluation/myEvaluation";
	}

}
