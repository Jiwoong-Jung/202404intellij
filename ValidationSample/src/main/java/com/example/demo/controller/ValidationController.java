package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.form.CalcForm;
import com.example.demo.validator.CalcValidator;

@Controller
public class ValidationController {
	/** 주입(인젝션) */
	@Autowired
	CalcValidator calcValidator;

	/** 커스텀 유효성 검사기 등록 */
	@InitBinder("calcForm")
	public void initBinder(WebDataBinder webDataBinder){
		webDataBinder.addValidators(calcValidator);
	}

	/** form-backing bean 초기화 */
	@ModelAttribute
	public CalcForm setUpForm() {
		return new CalcForm();
	}

	/** 입력 화면 표시 */
	@GetMapping("show")
	public String showView() {
		// 반환값으로 뷰 이름을 돌려줌
		return "entry";
	}

	/** 확인 화면을 표시: Form 클래스 이용 */
	@PostMapping("calc")
	public String confirmView(@Validated CalcForm form,
							  BindingResult bindingResult, Model model) {
		// 입력 체크에서 에러가 발생한 경우
		if (bindingResult.hasErrors()) {
			// 입력 화면으로
			return "entry";
		}

		// 값 더하기
		Integer result = form.getLeftNum() + form.getRightNum();

		// Model에 저장
		model.addAttribute("result", result);

		// 확인 화면으로
		return "confirm";
	}
}