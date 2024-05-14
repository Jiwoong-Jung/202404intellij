package com.sky._sb0507.controller;

import com.sky._sb0507.spring.Member;
import com.sky._sb0507.spring.MemberDao;
import com.sky._sb0507.spring.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class MemberDetailController {

	private final MemberDao memberDao;

	@GetMapping("/members/{id}")
	public String detail(@PathVariable("id") Long memId, Model model) {
		Member member = memberDao.selectById(memId);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		model.addAttribute("member", member);
		return "member/memberDetail";
	}

	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException() {
		return "member/invalidId";
	}

	@ExceptionHandler(MemberNotFoundException.class)
	public String handleNotFoundException() {
		return "member/noMember";
	}

}
