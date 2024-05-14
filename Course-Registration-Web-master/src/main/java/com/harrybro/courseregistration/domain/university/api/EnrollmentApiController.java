package com.harrybro.courseregistration.domain.university.api;

import com.harrybro.courseregistration.domain.university.dto.EnrollmentSaveResponse;
import com.harrybro.courseregistration.domain.university.service.EnrollmentService;
import com.harrybro.courseregistration.global.config.auth.PrincipalDetail;
import com.harrybro.courseregistration.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class EnrollmentApiController {

    private final EnrollmentService enrollmentService;

    @PostMapping("/enrollment/{id}")
    public ResponseDto<EnrollmentSaveResponse> save(@AuthenticationPrincipal PrincipalDetail principal,
                                                    @PathVariable("id") Long lectureId) {
        return enrollmentService.save(lectureId, principal);
    }

    @DeleteMapping("/enrollment/{id}")
    public ResponseDto<?> delete(@AuthenticationPrincipal PrincipalDetail principal,
                                 @PathVariable("id") Long lectureId) {
        return enrollmentService.delete(lectureId, principal);
    }

}
