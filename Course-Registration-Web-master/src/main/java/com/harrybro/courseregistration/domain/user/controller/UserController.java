package com.harrybro.courseregistration.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/auth/sign-up")
    public String createAccountForm() {
        return "sign_up";
    }

    @GetMapping("/api/v1/email-auth/success")
    public String authSuccess() {
        return "email_auth_success";
    }

}
