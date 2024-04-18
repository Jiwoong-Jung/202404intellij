package com.sky.controller;

import com.sky.spring.DuplicateMemberException;
import com.sky.spring.MemberRegisterService;
import com.sky.spring.RegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private MemberRegisterService memberRegisterService;


	@RequestMapping("/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}

	@GetMapping("/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/step3")
	public String handleStep3(RegisterRequest regReq) {
		try {
			memberRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateMemberException ex) {
			System.out.println("DuplicateMemberException 발생!!!");
			return "register/step2";
		}
	}

}
