package com.harrybro.courseregistration.domain.university.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnrollmentResponseMessage {

    SAVE_SUCCESS_TO_ENROLLMENT("선택한 과목을 수강신청 완료하였습니다."),
    DELETE_SUCCESS_TO_BASKET("선택한 과목을 수강 취소했습니다.");

    private final String message;
}
