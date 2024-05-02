package com.sky._sb0423.controller;

import java.util.List;

import com.sky._sb0423.spring.Member;
import com.sky._sb0423.spring.MemberDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class MemberListController {

	private final MemberDao memberDao;

	@RequestMapping("/members")
//	public String list(
//			@ModelAttribute("cmd") ListCommand listCommand,
//			Errors errors, Model model) {
	public String list(
			@ModelAttribute("cmd") ListCommand listCommand,
			Errors errors, Model model) {
		System.out.println(listCommand);
		if (errors.hasErrors()) {
			return "member/memberList";
		}
		if (listCommand.getFrom() != null && listCommand.getTo() != null) {
			List<Member> members = memberDao.selectByRegdate(
					listCommand.getFrom(), listCommand.getTo());
			model.addAttribute("members", members);
		}
		return "member/memberList";
	}

}