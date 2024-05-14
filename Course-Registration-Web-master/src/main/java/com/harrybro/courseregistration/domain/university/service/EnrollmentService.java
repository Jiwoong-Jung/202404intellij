package com.harrybro.courseregistration.domain.university.service;

import com.harrybro.courseregistration.domain.university.constant.EnrollmentResponseMessage;
import com.harrybro.courseregistration.domain.university.domain.Lecture;
import com.harrybro.courseregistration.domain.university.dto.EnrollmentCancelResponse;
import com.harrybro.courseregistration.domain.university.dto.EnrollmentSaveResponse;
import com.harrybro.courseregistration.domain.university.dto.UserAndLectureDto;
import com.harrybro.courseregistration.domain.university.util.UserAndLectureValidator;
import com.harrybro.courseregistration.domain.user.domain.User;
import com.harrybro.courseregistration.global.config.auth.PrincipalDetail;
import com.harrybro.courseregistration.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EnrollmentService {

    private final UserAndLectureValidator userAndLectureValidator;

    @Transactional
    public ResponseDto<EnrollmentSaveResponse> save(Long lectureId, PrincipalDetail principal) {
        UserAndLectureDto userAndLectureDto = userAndLectureValidator.validate(principal, lectureId);
        User user = userAndLectureDto.getUser();
        Lecture lecture = userAndLectureDto.getLecture();
        user.enroll(lecture);
        return ResponseDto.of(EnrollmentResponseMessage.SAVE_SUCCESS_TO_ENROLLMENT.getMessage(), EnrollmentSaveResponse.of(user, lecture));
    }

    @Transactional
    public ResponseDto<EnrollmentCancelResponse> delete(Long lectureId, PrincipalDetail principal) {
        UserAndLectureDto userAndLectureDto = userAndLectureValidator.validate(principal, lectureId);
        User user = userAndLectureDto.getUser();
        Lecture lecture = userAndLectureDto.getLecture();
        user.cancelEnrollment(lecture);
        return ResponseDto.of(EnrollmentResponseMessage.DELETE_SUCCESS_TO_BASKET.getMessage(), EnrollmentCancelResponse.from(user));
    }

}
