package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Member;

@Controller
public class ThymeleafController {

	@GetMapping("show")
	public String showView(Model model) {
		// Member를 생성
		Member member = new Member(1, "회원01");

		// 컬렉션 저장용 Member 생성
		Member member1 = new Member(10, "홍길동");
		Member member2 = new Member(20, "이영희");

		// List 생성
		List<String> directionList = new ArrayList<String>();
		directionList.add("동");
		directionList.add("서");
		directionList.add("남");
		directionList.add("북");

		// Map을 생성해서 Member를 저장
		Map<String, Member> memberMap = new HashMap<>();
		memberMap.put("hong", member1);
		memberMap.put("lee", member2);

		// List를 생성해서 Member를 저장
		List<Member> memberList = new ArrayList<>();
		memberList.add(member1);
		memberList.add(member2);

		// Model에 데이터 추가
		model.addAttribute("name", "이순신");
		model.addAttribute("mb",member);
		model.addAttribute("list",directionList);
		model.addAttribute("map", memberMap);
		model.addAttribute("members", memberList);

		// 반환값으로 뷰 이름을 설정
		return "useThymeleaf";
	}

	@GetMapping("a")
	public String showA() {
		return "pageA";
	}
}