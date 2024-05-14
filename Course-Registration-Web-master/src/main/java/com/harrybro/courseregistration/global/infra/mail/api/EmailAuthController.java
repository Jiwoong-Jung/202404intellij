package com.harrybro.courseregistration.global.infra.mail.api;

import com.harrybro.courseregistration.global.infra.mail.service.EmailAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping("api/v1")
@RestController
public class EmailAuthController {

    private final EmailAuthService emailAuthService;

    @GetMapping("email-auth")
    public void emailAuth(HttpServletResponse response, String email, String authCode) throws IOException {
        emailAuthService.emailValidate(email, authCode);
        response.sendRedirect("http://localhost/api/v1/email-auth/success");
    }

}
