package com.sky._sb0520_2.controller;

import com.sky._sb0520_2.member.MemberJoinRequestDto;
import com.sky._sb0520_2.member.MemberRepository;
import com.sky._sb0520_2.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String index(@AuthenticationPrincipal UserDetails user, Model model){
        if (user != null) {
            model.addAttribute("user",user.getUsername());
        } else {
            model.addAttribute("user","로그인 안된 ");
        }

        return "index";
    }

    @GetMapping("/login/login")
    public String loginPage(){

        return "login/login";
    }

    @GetMapping("/login/join")
    public String joinPage(){

        return "login/join";
    }

    @PostMapping("/login/join")
    public String userJoin(@ModelAttribute MemberJoinRequestDto requestDto) {
        if (memberRepository.findByUsername(requestDto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        memberService.addUser(requestDto);

        return "login/login";
    }

    @GetMapping("/admins")
    public String adminPage(){

        return "admin/admin";
    }

    @GetMapping("/posts")
    public String posts(@AuthenticationPrincipal UserDetails user, Model model){
        model.addAttribute("user",user.getUsername());
        return "post/post";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentException() {
        return "error/error";
    }

}
