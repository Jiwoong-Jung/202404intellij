package com.harrybro.courseregistration.global.infra.mail.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EmailExceptionMessage {

    AUTH_CODE_MISMATCH_EXCEPTION("인증코드가 일치하지 않습니다.");

    private final String message;

}
