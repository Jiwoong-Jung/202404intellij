package com.example.shop.member.controller;

import com.example.shop.member.dto.MemberFormDto;
import com.example.shop.member.entity.Member;
import com.example.shop.member.service.MemberService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Log4j2
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return "member/memberLogin";
    }
    

    @GetMapping("/new")
    public String memberForm(Model model) {
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "member/memberForm";
    }

    @PostMapping("/new")
    public String memberForm(@Valid MemberFormDto memberFormDto,
                             BindingResult bindingResult,Model model) {
        //annotation에서 에러가 있으면 다시 memberform으로 돌아간다 -> 바인딩 에러 시 처리
        if(bindingResult.hasErrors()) {
            return "member/memberForm";
        }

        try { //회원가입을 처리하는 구문
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e) { //회원가입 처리 시 문제가 생기면 에러메시지 띄우기
            model.addAttribute("errorMessage", e.getMessage());
            //문제가 있으면 회원가입으로 돌아감
            return "member/memberForm";
        }
        return "redirect:/";
    }

    @GetMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg","아이디 또는 패스워드가 잘못되었습니다.");
        return "member/memberLogin";
    }

}
