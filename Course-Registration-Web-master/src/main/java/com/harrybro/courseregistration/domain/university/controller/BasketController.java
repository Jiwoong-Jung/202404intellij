package com.harrybro.courseregistration.domain.university.controller;

import com.harrybro.courseregistration.domain.user.domain.User;
import com.harrybro.courseregistration.domain.user.service.UserService;
import com.harrybro.courseregistration.global.config.auth.PrincipalDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class BasketController {

    private final UserService userService;

    @Transactional(readOnly = true)
    @GetMapping("/basket")
    public String getBasket(Model model, @AuthenticationPrincipal PrincipalDetail principal) {
        User user = userService.findByEmail(principal.getUsername());
        model.addAttribute("credit", user.getCredit());
        model.addAttribute("basket_lectures", user.getBasket().getLectures());
        model.addAttribute("enrollment_lectures", user.getEnrollment().getLectures());
        return "basket";
    }


}
