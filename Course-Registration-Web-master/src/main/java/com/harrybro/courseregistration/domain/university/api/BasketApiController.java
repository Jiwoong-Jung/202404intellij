package com.harrybro.courseregistration.domain.university.api;

import com.harrybro.courseregistration.domain.university.service.BasketService;
import com.harrybro.courseregistration.global.config.auth.PrincipalDetail;
import com.harrybro.courseregistration.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class BasketApiController {

    private final BasketService basketService;

    @PostMapping("/basket/{id}")
    public ResponseEntity<ResponseDto<?>> saveLecture(@PathVariable("id") Long lectureID,
                                                      @AuthenticationPrincipal PrincipalDetail principal) {
        return ResponseEntity.ok(basketService.saveLecture(lectureID, principal));
    }

    @DeleteMapping("/basket/{id}")
    public ResponseEntity<ResponseDto<?>> deleteLecture(@PathVariable("id") Long lectureID,
                                                        @AuthenticationPrincipal PrincipalDetail principal) {
        return ResponseEntity.ok(basketService.deleteLecture(lectureID, principal));
    }

}
