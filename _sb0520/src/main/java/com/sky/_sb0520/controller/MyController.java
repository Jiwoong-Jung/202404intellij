package com.sky._sb0520.controller;

import com.sky._sb0520.dto.Member;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("member")
//@SessionAttributes("member")는 member라는 이름을 가진 모델(Model) 속성을 세션에 저장하겠다는 의미
// 이렇게 저장된 데이터는 해당 컨트롤러(Controller)에서만 사용할 수 있음.
@Controller
public class MyController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @ModelAttribute("member")
    public Member setMember() {
        return new Member();
    }

//    @GetMapping("/")
//    @ResponseBody
//    public Member root(@ModelAttribute("member") Member member) {
//        if (member.getMid() == null) {
//            member.setId(1L);
//            member.setMid("test");
//            member.setPass("1234");
//            return null;
//        }
//
//        return member;
//    }

    @GetMapping("/admin")
    String admin() {
        return "admin/admin";
    }

    @GetMapping("/member")
    String member() {
        return "member/member";
    }

    @GetMapping("/guest")
    String guest(@ModelAttribute("member") Member member, Model model) {
        if (member.getMid() == null) {
            return "redirect:/login";
        }
        model.addAttribute("member", member);
        return "guest/guest";
    }

    @GetMapping("/login")
    String login() {
        return "login";
    }

    @PostMapping("/login")
    public String performLogin(@RequestParam("id") String username,
                               @RequestParam("passwd") String password) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
            Authentication authentication = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "redirect:/";
        } catch (org.springframework.security.core.AuthenticationException e) {
            return "redirect:/login?error=true";
        }
    }
}
